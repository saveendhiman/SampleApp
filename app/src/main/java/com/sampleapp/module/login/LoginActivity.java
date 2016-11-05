package com.sampleapp.module.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.sampleapp.R;
import com.sampleapp.base.BaseActivity;
import com.sampleapp.utils.AppUtils;
import com.sampleapp.utils.ProgressBarHandler;
import com.sampleapp.utils.UtilsModule;
import com.sampleapp.views.RemoveErrorEditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import eu.inmite.android.lib.validations.form.FormValidator;
import eu.inmite.android.lib.validations.form.annotations.MinLength;
import eu.inmite.android.lib.validations.form.annotations.NotEmpty;
import eu.inmite.android.lib.validations.form.callback.SimpleErrorPopupCallback;

/**
 * Created by saveen_dhiman on 05-November-16.
 * contains login related view and data presentation
 */

public class LoginActivity extends BaseActivity implements LoginView {

    @Inject
    ProgressBarHandler mProgressHandler;
    @Inject
    LoginPresenter mLoginPresenter;
    @Inject
    AppUtils mAppUtils;

    @NotEmpty(messageId = R.string.warning_field_empty, order = 1)
    @BindView(R.id.edtUserName)
    RemoveErrorEditText mEdtUserName;

    @MinLength(value = 6, messageId = R.string.warning_password_length, order = 2)
    @BindView(R.id.edtPassword)
    RemoveErrorEditText mEdtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //create component
        DaggerLoginComponent.builder()
                .utilsModule(new UtilsModule(this))
                .loginModule(new LoginModule(this))
                .build().inject(this);

        mLoginPresenter.attachView(this);
    }

    //set layout for this activity
    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    //return intent for this activity
    public static Intent createIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    public void onLoginSuccess() {

    }

    @Override
    public void closeApplication() {

    }

    @Override
    public void showProgress() {
        mProgressHandler.showProgress();
    }

    @Override
    public void hideProgress() {
        mProgressHandler.hideProgress();
    }

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
        mAppUtils.showSnackBar(mEdtPassword, t.getLocalizedMessage());
    }

    @Override
    public void onException(String message) {
        mAppUtils.showSnackBar(mEdtPassword, message);
    }

    //click event on views
    @OnClick({R.id.txtLogin})
    public void onClick() {
        boolean isValid = FormValidator.validate(LoginActivity.this, new SimpleErrorPopupCallback(LoginActivity.this));
        if (isValid) {
            mLoginPresenter.loginUser(mEdtUserName.getText().toString(), mEdtPassword.getText().toString());
        }
    }
}
