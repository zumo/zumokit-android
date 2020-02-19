<h6 align="center">INTERNAL DEVELOPER GUIDE</h6>

<h1 align="center">
	ZumoKit SDK
</h1>

# Introduction

ZumoKit SDK provides native Android and iOS ZumoKit implementations. The Core Library of ZumoKit SDK is written in C++ for maximum cross platform compatibility which is then wrapped in correspoding Java and Objective-C wrappers for each platform respectively.

## Setup

This project uses Python build script `zumocore/build.py` to cross build its targets, which requires Python 3, path module and [Conan](https://conan.io/) dependency manager:
```
pip3 install path.py
pip3 install conan
conan remote add bincrafters https://api.bintray.com/conan/bincrafters/public-conan
conan remote add theodelrieu https://api.bintray.com/conan/theodelrieu/conan-repo
```

In order to build iOS binaries, **Xcode command line tools** are required. If you have [XCode](https://developer.apple.com/xcode/) installed, you can install them from command line:
```
xcode-select --install
```

## Usage

Build process can be executed by running `make all`, which generates Djinni interface files and then builds `test`, `android` and `ios` build targets. Each of this targets can be built in isolation by executing corresponding `make` command, eg. `make test`.

# Project Components

- **[Third party dependencies](thirdparty/)**
	- [djinni](https://github.com/dropbox/djinni/)
- **[C++ Core Library](zumocore/)**
- **[Android SDK](android/)**
- **[iOS SDK](ios/)**
- **[Web SDK](web/sdk)** (currently not under development)


## Project Structure

```
ROOT
├── android                // ZumoKit Android SDK
├── ios                    // ZumoKit iOS SDK
├── thirdparty
│   ├── djinni             // Djinni submodule
├── web                    // Web SDK (currently not under development)
├── zumocore               // ZumoCore C++ library
│   ├── conan              // Conan profiles
│   ├── idl                // Djinni IDL files
│   ├── include            // Djinni generated C++ interface
│   ├── scripts
│   │   ├── run_djinni.sh  // Djinni bash scriptt
│   ├── src                // C++ source code
│   ├── test               // tests
│   ├── thirdparty         // thirdparty dependencies
│   ├── build.py           // cross platform build script
│   ├── CMakeLists.txt     // CMake build script
│   ├── conanfile.py       // Conan project dependencies
│   ├── README.md
├── Makefile               // target specific Make scripts
├── README.md
```

## Djinni

Djinni is used to generate C++ Core Library's public headers as well as Android and iOS wrappers. It's controlled by a bash script found in `zumocore/scripts/run_djinni.sh`.

## C++ Core Library

C++ library is built by first generating Java, Objective-C and C++ interafce using Djinni, then installing project dependecies using Conan and building the project using CMake. Those steps are unified using a Python 3 build script `zumocore/build.py`.

## Android

Makefile command `make android` generates Java <-> C++ interace using Djinni, builds C++ Android binaries using `zumocore/build.py` and then builds and outputs Android SDK using Gradle build tool to `android/zumokit/build/outputs/aar`.

## iOS

Makefile command `make ios` generates Objective-C <-> C++ interace using Djinni and builds C++ iOS binaries (including universal binary) using `zumocore/build.py` script. Resulting build output is a CocoaPod in `ios` directory.

## Web

Web version is currently not under development.

# Testing and QA process

ZumoKit C++ Core leverages unit testing to ensure library stability. We use Googletest as our testing and mocking framework. C++ unit tests can be performed by running `make test`.

# Release process

Secion will be updated when build process and CircleCI integration is finalized.

# Git usage & development guidelines

### 1. Develop features on feature branches
- Use git flow naming conventions
- Use branch naming `feature/ZUMO-<TICKET-NUMBER>`, eg. `feature/ZUMO-333`
- Write [correctly formatted](https://github.com/erlang/otp/wiki/writing-good-commit-messages), grammaticaly correct commit messages:
	- Template: `<TICKET-ID> <VERB IN PRESENT TENSE> <WORK DONE>`
	- Example:`ZUMO-123 Implement SSL support in network library`

### 2. Make sure all tests pass

Execute  `make test` and make sure tests pass.

### 3. Make sure .gitignore files up to date

There is a global `.gitignore` in the repository root. It covers common rules for all project components. There are additional component specific rules which can be found in each component's root directory.

### 4. Make sure Readme files are up to date

This is the global Readme file. Component-specific Readme is in each component's root.

### 5. Use pull requests to request code review
- Make sure your feature branch is rebased with develop.
- [Squash all commits](https://git-scm.com/book/en/v2/Git-Tools-Rewriting-History) into one (or a few if bigger feature), and update final commit message if required.
- Create a pull request and move your ticket to correct column in Jira.
- Assign at least 2 reviewers to your pull request.
- Wait for approval.

### 6. When your PR is approved
- Make sure your feature branch is rebased with develop.
- [Squash all commits](https://git-scm.com/book/en/v2/Git-Tools-Rewriting-History) into one (or a few if bigger feature), and update final commit message if required.
- Rebase and merge using GitHub web interface.