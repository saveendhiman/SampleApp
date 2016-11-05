# SampleApp
# Android Project Structure

Hi guys, I have made one Project Structure for Android. This is the open project for any contributer who want to improve something here.

It include api's call through Retrofit and RX java.

Here i used dagger for dependency injection.

Firebase added for notifications.

Calligraphy for settings fonts.

Picasso for image loading. You can use here glide also.

Komensky for validations.

Febric for crashlytics.

Butterknife for declaring our controls.


# Here is our gradle look like this.

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
    compile "com.facebook.android:facebook-android-sdk:$rootProject.ext.facebookVersion"
    compile("com.crashlytics.sdk.android:crashlytics:$rootProject.ext.crashVersion@aar") {
        transitive = true;
    }
	
}

#Start from

minSdkVersion 14

#LICENSE

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

#Authors

https://github.com/saveendhiman original Author
