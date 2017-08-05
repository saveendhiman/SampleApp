package com.sampleapp.module.fragmentsample;

import android.app.Activity;

import com.sampleapp.api.RestService;
import com.sampleapp.base.SampleApplication;
import com.sampleapp.constants.ValueConstants;
import com.sampleapp.mvpbase.BasePresenter;
import com.sampleapp.utils.AppUtils;
import com.sampleapp.utils.PreferenceManager;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Scheduler;

/**
 * Created by saveen_dhiman on 05-August-17.
 * presenter class for {@link SampleFragment}
 */
public class SamplePresenter extends BasePresenter<SampleView> {

    @Inject
    PreferenceManager mPrefs;
    @Inject
    @Named(ValueConstants.MAIN_THREAD)
    Scheduler mMainThread;
    @Inject
    @Named(ValueConstants.NEW_THREAD)
    Scheduler mNewThread;
    @Inject
    AppUtils mAppUtils;

    @Inject
    RestService mRestService;

    @Inject
    public SamplePresenter() {
    }

    //inject dependency for presenter
    void injectDependency(Activity activity) {
        ((SampleApplication) activity.getApplication()).getAppComponent().inject(this);
    }

}
