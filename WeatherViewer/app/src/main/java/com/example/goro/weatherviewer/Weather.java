package com.example.goro.weatherviewer;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by Goro on 11.08.2017.
 */

class Weather {
    public final String dayOfWeek;
    public final String minTemp;
    public final String maxTemp;
    public final String humidity;
    public final String description;
    public final String iconURL;

    public Weather(long timeStamp, double minTemp, double maxTemp, double humidity, String description, String iconName) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(1);

        this.dayOfWeek = convertTimeStampToDay(timeStamp);
        this.minTemp = numberFormat.format(minTemp-273.15) + "\u00B0C";
        this.maxTemp = numberFormat.format(maxTemp-273.15) + "\u00B0C";
        this.humidity = NumberFormat.getPercentInstance().format(humidity / 100.0);
        this.description = description;
        this.iconURL = "http://openweathermap.org/img/w/" + iconName + ".png";
    }

    private String convertTimeStampToDay(long dayOfWeek) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(dayOfWeek * 1000);
        TimeZone tz = TimeZone.getDefault();

        calendar.add(Calendar.MILLISECOND, tz.getOffset(calendar.getTimeInMillis()));

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
        return dateFormat.format(calendar.getTime());
    }
}
