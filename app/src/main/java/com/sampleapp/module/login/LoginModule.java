package com.sampleapp.module.login;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by saveen_dhiman on 05-November-16.
 * provides dependencies for LoginActivity
 */
@Module
public class LoginModule {

    private Context mContext;

    public LoginModule(Context mContext) {
        this.mContext = mContext;
    }

    //returns LoginPresenter object
    @Provides
    LoginPresenter getPresenter() {
        return new LoginPresenter(mContext);
    }
}
