package com.sampleapp.base;

import com.sampleapp.utils.LocationTracker;
import com.sampleapp.utils.UtilsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by saveen_dhiman on 05-November-16.
 * Injections for Application class
 */

@Singleton
@Component(modules = {UtilsModule.class})
public interface AppComponent {
    void inject(LocationTracker locationTracker);
}
