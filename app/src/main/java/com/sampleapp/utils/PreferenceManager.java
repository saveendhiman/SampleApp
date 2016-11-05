package com.sampleapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.sampleapp.constants.PrefernceConstants;
import com.sampleapp.model.UserData;


/**
 * Created by saveen_dhiman on 05-November-16.
 * Contains method to store and retrieve SharedPreferences data
 */
public class PreferenceManager {

    private static Context context1;

    public PreferenceManager(Context context) {
        PreferenceManager.context1 = context;
    }

    //get shared pref
    private SharedPreferences getPreferences() {
        return context1.getSharedPreferences(PrefernceConstants.PREFERENCE_NAME, Context.MODE_PRIVATE);
    }


    //save data of current logged in user
    public void setUserData(String userData) {
        getPreferences().edit().putString(PrefernceConstants.USER_DATA, userData).commit();
    }

    //get user data as string
    private String getUserDataFromPref() {
        return getPreferences().getString(PrefernceConstants.USER_DATA, null);
    }

    //get saved data of current user as an object
    public UserData.ResponseBean.AuthBean getUserData() {
        UserData.ResponseBean.AuthBean userData = null;
        if (getUserDataFromPref() != null) {
            userData = new Gson().fromJson(getUserDataFromPref(), UserData.ResponseBean.AuthBean.class);
        }
        return userData;
    }

    //returns true when user is logged in
    public void setUserLoggedIn(boolean isLogin) {
        getPreferences().edit().putBoolean(PrefernceConstants.IS_LOGIN, isLogin).commit();
    }

    //set true when user is logegd in else false
    public boolean isUserLoggedIn() {
        return getPreferences().getBoolean(PrefernceConstants.IS_LOGIN, false);
    }

    //clear user shared preferences
    public void clearPrefrences() {
        getPreferences().edit().clear().commit();
    }

}