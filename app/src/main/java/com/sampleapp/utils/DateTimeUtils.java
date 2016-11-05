package com.sampleapp.utils;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by saveen_dhiman on 05-November-16.
 * contains commonly used methods related to date & time conversion
 */
public class DateTimeUtils {
    /**
     * get date form timestamp
     *
     * @param timestamp time to be converter
     * @return date in string
     */

    public String getDateFromTimestamp(String timestamp) {

        long time = Long.parseLong(timestamp) * 1000;
        try {
            DateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
            Date netDate = (new Date(time));
            return sdf.format(netDate);
        } catch (Exception ex) {
            return "xx xxxx xxxx";
        }
    }

    /**
     * To convert a date to timestamp
     *
     * @param dateToConvert date to be converted
     * @param dateFormat    format of date entered
     * @return timestamp in milliseconds
     */

    public long convertDateToTimeStamp(String dateToConvert, String dateFormat) {
        DateFormat formatter = new SimpleDateFormat(dateFormat, Locale.getDefault());
        Date date = null;
        try {
            date = formatter.parse(dateToConvert);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    /**
     * Get current timestamp in seconds
     *
     * @return current device time in seconds
     */
    public static long getTimeStampInSeconds() {
        return System.currentTimeMillis() / 1000;
    }


    /**
     * get difference between current time and provided timezone
     *
     * @return
     */
    public long getTimeOffset() {
        long currentTime = System.currentTimeMillis();
        int edtOffset = TimeZone.getTimeZone("Your Time Zone").getOffset(currentTime);
        int current = TimeZone.getDefault().getOffset(currentTime);
        return current - edtOffset;
    }

    /**
     * Convert date from one format to another
     *
     * @param dateToConvert date to be converted
     * @param formatFrom    the format of the date to be converted
     * @param formatTo      the format of date you want the output
     * @return date in string as per the entered formats
     */
    @SuppressLint("SimpleDateFormat")
    public String convertDateOneToAnother(String dateToConvert, String formatFrom, String formatTo) {
        String outputDateStr = null;
        DateFormat inputFormat = new SimpleDateFormat(formatFrom);
        DateFormat outputFormat = new SimpleDateFormat(formatTo);
        Date date;
        try {
            date = inputFormat.parse(dateToConvert);
            outputDateStr = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return outputDateStr;
    }
}
