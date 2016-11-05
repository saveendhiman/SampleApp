package com.sampleapp.module.register;

import android.os.Bundle;

import com.sampleapp.R;
import com.sampleapp.base.BaseActivity;

/**
 * Created by saveen_dhiman on 05-November-16.
 * contains register related view and data presentation
 */
public class RegisterActivity extends BaseActivity implements RegisterMvpView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    public void OnSuccess() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onException(String message) {

    }
}
