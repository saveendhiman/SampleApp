package com.sampleapp.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.Settings;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.sampleapp.R;

/**
 * Created by saveen_dhiman on 05-November-16.
 * <p/>
 * Contains commonly used methods in an Android App
 */
public class AppUtils {

    private Context mContext;

    public AppUtils(Context context) {
        this.mContext = context;
    }

    /**
     * Description : Check if user is online or not
     *
     * @return true if online else false
     */
    public boolean isOnline(View v) {
        ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        showSnackBar(v, mContext.getString(R.string.toast_network_not_available));
        return false;
    }


    /**
     * Description : Hide the soft keyboard
     *
     * @param view : Pass the current view
     */
    public void hideSoftKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) mContext.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /**
     * Show snackbar
     *
     * @param view view clicked
     * @param text text to be displayed on snackbar
     */
    public void showSnackBar(View view, String text) {
//        Snackbar.make(view, text, Snackbar.LENGTH_SHORT).show();
    }

    /**
     * Show snackbar
     *
     * @param text text to be displayed on Toast
     */
    public void showToast(String text) {
        Toast.makeText(mContext, text, Toast.LENGTH_SHORT).show();
    }

    /**
     * send email via. intent
     *
     * @param email to whom you want to send email
     */
    public void sendEmail(Context context, String email) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, email);
        try {
            context.startActivity(Intent.createChooser(i, context.getResources().getString(R.string.send_mail)));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(context, context.getResources().getString(R.string.no_email_client), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * To open a website in phone browser
     *
     * @param address valid email link
     */
    public void openBrowser(String address) {
        try {
            if (!address.startsWith("http://") && !address.startsWith("https://")) {
                address = "http://" + address;
            }
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(address));
            mContext.startActivity(browserIntent);
        } catch (Exception e) {
            showToast(mContext.getResources().getString(R.string.warning_invalid_link));
        }
    }

    /**
     * Check the device to make sure it has the Google Play Services APK. If
     * it doesn't, display a dialog that allows users to download the APK from
     * the Google Play Store or enable it in the device's system settings.
     */
    public boolean checkPlayServices() {
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = apiAvailability.isGooglePlayServicesAvailable(mContext);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (apiAvailability.isUserResolvableError(resultCode)) {
                apiAvailability.getErrorDialog((Activity) mContext, resultCode, 9000)
                        .show();
            } else {
                showToast(mContext.getResources().getString(R.string.warning_play_services));
            }
            return false;
        }
        return true;
    }

    /**
     * redirect user to your application settings in device
     */
    public void redirectToAppSettings() {
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", mContext.getPackageName(), null);
        intent.setData(uri);
        mContext.startActivity(intent);
    }

    /**
     * check if user has enabled Gps of device
     *
     * @return true or false depending upon device Gps status
     */
    public boolean isGpsEnabled() {
        final LocationManager manager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
        return manager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    /**
     * Redirect user to enable GPS
     */
    public void goToGpsSettings() {
        Intent callGPSSettingIntent = new Intent(
                Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        mContext.startActivity(callGPSSettingIntent);
    }

}