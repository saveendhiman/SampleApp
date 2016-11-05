package com.sampleapp.utils;

import android.content.Context;

import com.sampleapp.constants.ValueConstants;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by saveen_dhiman on 05-November-16.
 * Provide injects for utility objects
 */

@Module
public class UtilsModule {

    private Context mContext;

    public UtilsModule(Context context) {
        this.mContext = context;
    }

    // get AppUtils instance
    @Provides
    @Singleton
    public AppUtils getAppUtils() {
        return new AppUtils(mContext);
    }

    // get DateTimeUtils instance
    @Provides
    @Singleton
    public DateTimeUtils getDateTimeUtils() {
        return new DateTimeUtils();
    }

    // get ProgressBarHandler instance
    @Provides
    @Singleton
    public ProgressBarHandler getProgressBar() {
        return new ProgressBarHandler(mContext);
    }

    //get dialog utils
    @Provides
    @Singleton
    public DialogsUtil getDialogUtils() {
        return new DialogsUtil(mContext);
    }

    //get new thread
    @Provides
    @Singleton
    @Named(ValueConstants.NEW_THREAD)
    public Scheduler getNewThread() {
        return Schedulers.io();
    }

    //get main thread
    @Provides
    @Singleton
    @Named(ValueConstants.MAIN_THREAD)
    public Scheduler getMainThread() {
        return AndroidSchedulers.mainThread();
    }

    //get Preference Manager
    @Provides
    @Singleton
    public PreferenceManager getPreferences() {
        return new PreferenceManager(mContext);
    }

    //get Fragment utils
    @Provides
    @Singleton
    public FragmentUtils getFragUtils() {
        return new FragmentUtils();
    }

    //get location helper methods
    @Provides
    @Singleton
    public LocationHelper getLocationUtils() {
        return new LocationHelper(mContext);
    }

    //get location tracker
    @Provides
    @Singleton
    public LocationTracker getLocationTrackerOF() {
        return new LocationTracker(mContext);
    }

    //get image utils
    @Provides
    @Singleton
    public ImageUtility getImageUtils() {
        return new ImageUtility(mContext);
    }

}
