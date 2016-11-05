package com.sampleapp.module.login;

import android.content.Context;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;
import com.sampleapp.api.NetModule;
import com.sampleapp.api.RestService;
import com.sampleapp.constants.ApiConstants;
import com.sampleapp.constants.ValueConstants;
import com.sampleapp.model.request.LoginRequest;
import com.sampleapp.model.response.LoginResponse;
import com.sampleapp.mvpbase.BasePresenter;
import com.sampleapp.utils.AppUtils;
import com.sampleapp.utils.PreferenceManager;
import com.sampleapp.utils.UtilsModule;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Scheduler;

/**
 * Created by saveen_dhiman on 05-November-16.
 * Presenter class for LoginActivity
 * Contains all the business logic for main activity
 */
public class LoginPresenter extends BasePresenter<LoginView> {

    @Inject
    @Named(ValueConstants.MAIN_THREAD)
    Scheduler mMainThread;

    @Inject
    @Named(ValueConstants.NEW_THREAD)
    Scheduler mNewThread;

    @Inject
    RestService mRestService;

    @Inject
    PreferenceManager mprefs;

    @Inject
    AppUtils mUtils;

    public LoginPresenter(Context context) {
        //create component
        DaggerLoginPresenterComponent.builder()
                .netModule(new NetModule())
                .utilsModule(new UtilsModule(context)).build().inject(this);
    }

    //login user api method
    public void loginUser(String userName, String password) {

        getMvpView().showProgress();

        LoginRequest request = new LoginRequest(userName, password,
                ValueConstants.DEVICE_TYPE, FirebaseInstanceId.getInstance().getToken());

        mRestService.login(request).
                subscribeOn(mNewThread).
                observeOn(mMainThread).
                subscribe(loginResponse -> {
                    if (isViewAttached()) {
                        getMvpView().hideProgress();
                        if (loginResponse.getResponse().getResult() == ApiConstants.STATUS_SUCCESS) {
                            mprefs.setUserLoggedIn(true);
                            LoginResponse.ResponseBean response = loginResponse.getResponse();
//                            response.setAvatar(loginResponse.getResponse().getDp_path() + loginResponse.getResponse().getAvatar());
                            mprefs.setUserData(new Gson().toJson(response));
                            getMvpView().onLoginSuccess();
                        } else {
                            getMvpView().onException(loginResponse.getResponse().getErrorMSG());
                        }
                    }
                }, throwable -> {
                    if (isViewAttached()) {
                        getMvpView().hideProgress();
                        getMvpView().onError(throwable);
                    }
                });

    }
}
