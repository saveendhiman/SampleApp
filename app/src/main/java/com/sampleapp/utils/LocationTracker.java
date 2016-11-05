package com.sampleapp.utils;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.sampleapp.R;
import com.sampleapp.base.SampleApplication;

import javax.inject.Inject;

import timber.log.Timber;

@SuppressWarnings("MissingPermission")
public class LocationTracker implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private Context context;
    private GoogleApiClient mGoogleApiClient;
    private static int UPDATE_INTERVAL = 0;
    private static int FATEST_INTERVAL = 0;
    private static int DISPLACEMENT = 2000; // 2KM
    private LocationRequest mLocationRequest;
    private Location mLastLocation;
    private onLocationListener listener;

    @Inject
    AppUtils mAppUtils;

    public LocationTracker(Context context) {
        this.context = context;

        ((SampleApplication)context).getAppComponent().inject(this);

        if (mAppUtils.checkPlayServices()) {
            buildGoogleApiClient();
            createLocationRequest();
            if (mGoogleApiClient != null) {
                mGoogleApiClient.connect();
            }
        } else {
            mAppUtils.showToast(context.getResources().getString(R.string.warning_play_services));
        }
    }


    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(context)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API).build();
    }

    @Override
    public void onConnected(Bundle bundle) {
        displayLocation();
        startLocationUpdates();
    }

    @Override
    public void onConnectionSuspended(int i) {
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Timber.e(connectionResult.toString());
    }

    /**
     * Creating location request object
     */
    private void createLocationRequest() {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(UPDATE_INTERVAL);
        mLocationRequest.setFastestInterval(FATEST_INTERVAL);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setSmallestDisplacement(DISPLACEMENT);
    }

    /**
     * Method to display the location on UI
     */
    private void displayLocation() {
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (mLastLocation != null) {
            double latitude = mLastLocation.getLatitude();
            double longitude = mLastLocation.getLongitude();
            Timber.e(latitude + "," + longitude);
            listener.onConnected(mLastLocation);
        }
    }

    /**
     * Starting the location updates
     */
    private void startLocationUpdates() {
        LocationServices.FusedLocationApi
                .requestLocationUpdates(mGoogleApiClient, mLocationRequest, locationListener);
        Timber.e("startLocationUpdates");
    }

    /**
     * Stopping location updates
     */
    public void stopLocationUpdates() {
        try {
            LocationServices.FusedLocationApi
                    .removeLocationUpdates(mGoogleApiClient, locationListener);
            Timber.e("stopLocationUpdates");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            mLastLocation = location;
            displayLocation();
        }
    };

    public void setLocationListener(onLocationListener listener) {
        this.listener = listener;
    }

    public interface onLocationListener {
        void onConnected(Location location);
    }
}