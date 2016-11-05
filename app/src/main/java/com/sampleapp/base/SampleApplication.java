package com.sampleapp.base;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.sampleapp.BuildConfig;
import com.sampleapp.utils.UtilsModule;

import io.fabric.sdk.android.Fabric;
import timber.log.Timber;


/**
 * Created by saveen_dhiman on 05-November-16.
 * Initialization of required libraries
 */
public class SampleApplication extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());

        //create component
        mAppComponent = DaggerAppComponent.builder()
                .utilsModule(new UtilsModule(this)).build();

        //configure timber for logging
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
