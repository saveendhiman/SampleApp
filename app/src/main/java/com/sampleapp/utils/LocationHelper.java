package com.sampleapp.utils;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by saveen_dhiman on 05-November-16.
 * contains helper methods to manipulate user location
 */
public class LocationHelper {

    private Context mContext;

    public LocationHelper(Context context) {
        this.mContext = context;
    }

    /**
     * @param latitude  latitude of address
     * @param longitude longitude of address
     * @return simplified address of location
     */

    public String getSimplifiedAddress(double latitude, double longitude) {
        String location = "";
        try {
            Geocoder geocoder = new Geocoder(mContext, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses.size() > 0) {
                Address address = addresses.get(0);
                String admin = address.getAdminArea();
                String subLocality = address.getSubLocality();
                String locality = address.getLocality();
                if (admin.length() > 10) {
                    admin = admin.substring(0, 10) + "..";
                }
                if (locality != null && subLocality != null) {
                    location = subLocality + "," + locality;
                } else if (subLocality != null) {
                    location = subLocality + "," + admin;
                } else {
                    location = locality + "," + admin;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return location;
    }

    /**
     * @param latitude  latitude of address
     * @param longitude longitude of address
     * @return complete address of location
     */

    public String getCompleteAddress(double latitude, double longitude) {
        String location = "";
        try {
            Geocoder geocoder = new Geocoder(mContext, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses.size() > 0) {
                Address address = addresses.get(0);
                String state, city, zip, street;
                if (address.getAdminArea() != null) {
                    state = address.getAdminArea();
                } else {
                    state = "";
                }
                if (address.getLocality() != null) {
                    city = address.getLocality();
                } else {
                    city = "";
                }
                if (address.getPostalCode() != null) {
                    zip = address.getPostalCode();
                } else {
                    zip = "";
                }

                if (address.getThoroughfare() != null) {
                    street = address.getSubLocality() + "," + address.getThoroughfare();
                } else {
                    street = address.getSubLocality() + "," + address.getFeatureName();
                }
                location = street + "," + city + "," + zip + "," + state;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return location;
    }

    /**
     * Calculate distance between two
     *
     * @param src lat/long of source
     * @param des lat/lng of destination
     * @return distance between two location in miles
     */
    public double calculateDistance(LatLng src, LatLng des) {
        double distance;
        double finalValue = 0;
        try {
            Location locationA = new Location("");
            locationA.setLatitude(src.latitude);
            locationA.setLongitude(src.longitude);
            Location locationB = new Location("");
            locationB.setLatitude(des.latitude);
            locationB.setLongitude(des.longitude);
            distance = locationA.distanceTo(locationB) / 1000;
            finalValue = Math.round(distance * 100.0) / 100.0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return finalValue;
    }

    /**
     * to get latitude and longitude of an address
     *
     * @param strAddress address string
     * @return lat and lng in comma separated string
     */
    public String getLocationFromAddress(String strAddress) {

        Geocoder coder = new Geocoder(mContext);
        List<Address> address;

        try {
            address = coder.getFromLocationName(strAddress, 1);
            if (address == null) {
                return null;
            }
            Address location = address.get(0);
            double lat = location.getLatitude();
            double lng = location.getLongitude();

            return lat + "," + lng;
        } catch (Exception e) {
            return null;
        }
    }
}