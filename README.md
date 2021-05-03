# ZumoKit Android SDK

ZumoKit is a state of the art wallet architecture underpinning our flagship product [Zumo](https://www.zumo.money/) that provides secure transfer and exchange of fiat and cryptocurrency funds.

## Docs

Refer to ZumoKit SDK developer [documentation](https://developers.zumo.money/docs/) and [reference](https://zumo.github.io/zumokit-android/) for usage details.

## Requirements

- Android 5.0 (API level 21) and above
- Android Gradle Plugin 3.5.1
- Gradle 5.3.1+

## Installation

Add the JitPack repository to your root build.gradle at the end of repositories:

```java
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Add the dependency:
```java
dependencies {
    implementation 'com.github.zumo:zumokit-android:X.Y.Z'
}
```

## Example

The [example project](https://github.com/zumo/zumokit-android/tree/master/example) demonstrates the expected user flow, including authentication process, wallet creation and transaction submission. Ask your [account manager](mailto:support@zumo.money) to provide you with neccesarry credentials.

To run the example project, clone the repo, open  the project in Android Studio and build & run the project.

NOTE: You need to install the [git-lfs client](https://git-lfs.github.com/) to be able to clone this repository.

