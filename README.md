# SampleApp
# Android Project Structure


[![Codacy Badge](https://api.codacy.com/project/badge/Grade/2a8eb532d98842f6966bc164a896419a)](https://www.codacy.com/app/saveendhiman/SampleApp?utm_source=github.com&utm_medium=referral&utm_content=saveendhiman/SampleApp&utm_campaign=badger)
[![Twitter](https://img.shields.io/badge/Twitter-@saveendhiman-blue.svg?style=flat)](https://twitter.com/saveendhiman)

[![API](https://img.shields.io/badge/API-14%2B-yellow.svg?style=flat)](https://android-arsenal.com/api?level=14)

[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)


Hi guys, I have made one Project Structure for Android. This is the open project for any contributer who want to improve something here.

This a Sample Project Structure for Android which you can follow for a clean architecture.

It shows usage of following libraries:

* [Retrofit2] (https://square.github.io/retrofit/) for REST API.

* [RX java] (https://github.com/ReactiveX/RxJava) for background process and Retrofit integration.

* [Dagger2] (https://google.github.io/dagger/) for dependency injection.

* [Firebase] (https://firebase.google.com/) for push notifications.

* [Calligraphy] (https://github.com/chrisjenx/Calligraphy) for font.

* [Picasso] (http://square.github.io/picasso/) for image loading.

* [Komensky] (https://github.com/inmite/android-validation-komensky) validations for annotation based validations.

* [Fabric] (https://get.fabric.io/#) for crashlytics.

* [Butterknife] (http://jakewharton.github.io/butterknife/) for view binding.

* [Timber] (https://github.com/JakeWharton/timber) for logging.

It uses MVP (Model View Presenter) pattern. MVP is a derivative from the well known MVC (Model View Controller), which for a while now is gaining importance in the development of Android applications.This project also contains basic utility classes required for day to day programming.


Location Handling by fused api.

Utils classes.


# Here is what the app gradle look likes.

    buildscript {
    repositories {
        maven { url 'https://maven.fabric.io/public' }
    }

    dependencies {
        classpath 'io.fabric.tools:gradle:1.+'
    }
    }
    apply plugin: 'com.android.application'
    apply plugin: 'io.fabric'
    apply plugin: 'com.neenbedankt.android-apt'
    apply plugin: 'me.tatarka.retrolambda'

    android {
    compileSdkVersion rootProject.ext.compileSdkVersion
    buildToolsVersion rootProject.ext.buildToolsVersion

    //app versioning
    def versionMajor = 1
    def versionMinor = 0
    def versionPatch = 0
    def versionBuild = 0

    defaultConfig {
        applicationId "com.sampleapp"
        minSdkVersion rootProject.ext.minSdkVersion
        targetSdkVersion rootProject.ext.targetSdkVersion
        versionCode versionMajor * 10000 + versionMinor * 1000 + versionPatch * 100 + versionBuild
        versionName "${versionMajor}.${versionMinor}.${versionPatch}"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    }

    repositories {
    maven {
        url "https://jitpack.io"
    }
    maven { url 'https://maven.fabric.io/public' }
    }

    dependencies {
    compile fileTree(include: ['*.jar'], dir: 'libs')
    compile "com.android.support:appcompat-v7:$rootProject.supportLibraryVersion"
    compile "com.android.support:design:$rootProject.supportLibraryVersion"
    apt "com.google.dagger:dagger-compiler:$rootProject.daggerVersion"
    provided "org.glassfish:javax.annotation:$rootProject.ext.annotationVersion"
    compile "com.google.dagger:dagger:$rootProject.daggerVersion"
    compile "com.squareup.retrofit2:retrofit:$rootProject.ext.retrofitVersion"
    compile "com.squareup.retrofit2:converter-gson:$rootProject.ext.retrofitVersion"
    compile "com.squareup.retrofit2:adapter-rxjava:$rootProject.ext.retrofitVersion"
    compile "com.squareup.okhttp3:logging-interceptor:$rootProject.ext.loggerVersion"
    compile "io.reactivex:rxjava:$rootProject.ext.rxJavaVersion"
    compile "io.reactivex:rxandroid:$rootProject.ext.rxAndroidVersion"
    compile "com.jakewharton:butterknife:$rootProject.ext.butterknifeVersion"
    apt "com.jakewharton:butterknife-compiler:$rootProject.ext.butterknifeVersion"
    compile "com.jakewharton.timber:timber:$rootProject.ext.timberVersion"
    compile "com.google.android.gms:play-services-location:$rootProject.ext.playServiceVersion"
    compile "com.google.firebase:firebase-messaging:$rootProject.ext.playServiceVersion"
    compile "com.google.android.gms:play-services-maps:$rootProject.ext.playServiceVersion"
    compile "uk.co.chrisjenx:calligraphy:$rootProject.ext.calligraphyVersion"
    compile "com.squareup.picasso:picasso:$rootProject.ext.picassoVersion"
    compile "eu.inmite.android.lib:android-validation-komensky:$rootProject.ext.komenskyValidation@aar"
    compile("com.crashlytics.sdk.android:crashlytics:$rootProject.ext.crashVersion@aar") {
        transitive = true;
    }
	
    }
    apply plugin: 'com.google.gms.google-services'
    
##DONATIONS

This project needs you! If you would like to support this project's further development, the creator of this project or the continuous maintenance of this project, feel free to donate. Your donation is highly appreciated (and I love food, coffee and beer). Thank you!

**PayPal**

* **[Donate $5]**: Thank's for creating this project, here's a coffee (or some beer) for you!

* **[Donate $10]**: Wow, I am stunned. Let me take you to the movies!ù

* **[Donate $15]**: I really appreciate your work, let's grab some lunch!

* **[Donate $25]**: That's some awesome stuff you did right there, dinner is on me!

* **[Donate $50]**: I really really want to support this project, great job!

* **[Donate $100]**: You are the man! This project saved me hours (if not days) of struggle and hard work, simply awesome!

* **[Donate $2799]**: Go buddy, buy Macbook Pro for yourself!

Of course, you can also choose what you want to donate, all donations are awesome!!


#Start from

minSdkVersion 14

#LICENSE

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

#Authors

https://github.com/saveendhiman original Author


[Donate $5]: 		https://www.paypal.me/saveendhiman/5
[Donate $10]:  		https://www.paypal.me/saveendhiman/10
[Donate $15]:  		https://www.paypal.me/saveendhiman/15
[Donate $25]:  		https://www.paypal.me/saveendhiman/25
[Donate $50]: 		https://www.paypal.me/saveendhiman/50
[Donate $100]: 		https://www.paypal.me/saveendhiman/100
[Donate $2799]: 	https://www.paypal.me/saveendhiman/2799

