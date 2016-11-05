package com.sampleapp.module.login;

import com.sampleapp.api.NetModule;
import com.sampleapp.utils.UtilsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by saveen_dhiman on 05-November-16.
 * Component class for login activity
 */
@Singleton
@Component(modules = {NetModule.class, UtilsModule.class})
public interface LoginPresenterComponent {
    void inject(LoginPresenter loginPresenter);
}
