# ZumoKit Android SDK

ZumoKit Android SDK is provided as an Android Archive Library (AAR). The AAR can be dropped into your existing Android Studio project without the need for modification to your folder structure or Gradle files.  In the future, maven repository should be available for easy integration into projects.

## Example

The [example project](example/) demonstrates the expected user flow, including authentication process, wallet creation and transaciton submission. Ask your [account manager](support@zumo.money) to provide you with neccesarry credentials.

To run the example project, clone the repo, open  the project in Android Studio and build & run the project.

## Requirements

- Android 5.0 (API level 21) and above
- Android Gradle Plugin 3.5.1
- Gradle 5.3.1+

## Installation

Add the JitPack repository to your root build.gradle at the end of repositories:

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Add the dependency:
```
dependencies {
    implementation 'com.github.zumo:zumokit-android:X.Y.Z'
}
```
