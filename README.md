# ZumoKit Android SDK

ZumoKit Android SDK is provided as an Android Archive Library (AAR). The AAR can be dropped into your existing Android Studio project without the need for modification to your folder structure or Gradle files.  In the future, maven repository should be available for easy integration into projects.

## Example

The [example project](example/) demonstrates the expected user flow, including authentication process, wallet creation and transaction submission. Ask your [account manager](support@zumo.money) to provide you with neccesarry credentials.

To run the example project, clone the repo, open  the project in Android Studio and build & run the project.

## Requirements

- Install or update [Android Studio](https://developer.android.com/studio) to its latest version
- Make sure that your app meets the following requirements:
  - Targets API level 21 or later
  - Uses Java 8

## Installation

Copy the AAR file `zumokit-android-X.Y.Z.aar` into the `libs` folder in your project. Create this folder if it doesn’t exist. It needs to be located in the same folder as your application's Gradle build file, not the top level project folder.

Declare the `libs` folder as a dependency repository in your application Gradle script:

```
repositories {
    flatDir {
        dirs 'libs'
    }
}
```

Declare AAR library as a dependency and add required transitive dependencies. In the future, when we  migrate to maven repository, transitive dependencies will be added automatically.

```
dependencies {
    implementation(name:'zumokit', ext:'aar')
    implementation 'org.java-websocket:Java-WebSocket:1.4.0'
}
```

Update Gradle script to require Java version 8:

```
compileOptions {
    sourceCompatibility JavaVersion.VERSION_1_8
    targetCompatibility JavaVersion.VERSION_1_8
}
```

Add internet use permission to your app's `AndroidManifest.xml` unless already added:

```xml
<uses-permission android:name="android.permission.INTERNET" />
```