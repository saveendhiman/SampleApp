package com.sampleapp.model.request;

import android.support.annotation.NonNull;

/**
 * Created by saveen_dhiman on 05-November-16.
 * type of data to be sent in LoginApi
 */
public class LoginRequest {

    String username;
    String password;
    String platform;
    String deviceid;

    public LoginRequest(@NonNull String username, @NonNull String password,
                        @NonNull String platform, @NonNull String deviceid) {
        this.username = username;
        this.password = password;
        this.platform = platform;
        this.deviceid = deviceid;
    }
}
