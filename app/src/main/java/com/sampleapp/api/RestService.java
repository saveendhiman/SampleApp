package com.sampleapp.api;

import com.sampleapp.constants.ApiConstants;
import com.sampleapp.model.request.LoginRequest;
import com.sampleapp.model.response.LoginResponse;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by saveen_dhiman on 05-November-16.
 * Contains API methods to be consumed
 */
public interface RestService {

    //LOGIN API
    @POST(ApiConstants.LOGIN)
    Observable<LoginResponse> login(@Body LoginRequest loginRequest);

}
