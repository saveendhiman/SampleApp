package com.sampleapp.module.login;

import com.sampleapp.mvpbase.MvpView;

/**
 * Created by saveen_dhiman on 05-November-16.
 * contains methods to perform action via presenter
 */
public interface LoginView extends MvpView {

    void onLoginSuccess();

    void closeApplication();

}
