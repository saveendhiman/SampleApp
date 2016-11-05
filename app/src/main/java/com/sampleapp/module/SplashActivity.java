package com.sampleapp.module;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sampleapp.R;
import com.sampleapp.module.login.LoginActivity;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;

/**
 * Created by saveen_dhiman on 05-November-16.
 * initial screen for application to present app logo to users
 */

public class SplashActivity extends AppCompatActivity {

    private Subscription mSubscriber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //start next activity after delay of 2 seconds
        mSubscriber = Observable.timer(2, TimeUnit.SECONDS).subscribe(aLong -> {
            startActivity(LoginActivity.createIntent(SplashActivity.this));
            finish();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSubscriber.unsubscribe();
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
