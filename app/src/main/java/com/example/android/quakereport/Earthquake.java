package com.example.android.quakereport;

/**
 * Created by SeniKamara on 03.06.2018.
 * {@link Earthquake} represents a match that the user wants to watch or enquire about.
 * It contains the names of the teams participating in the match as well as the date
 * and time when the match is played, as well as the button to view the information
 * about the venue for the match.
 */

public class Earthquake {

    /** Magnitude of the Earthquake */
    private double mEarthquakeMagnitude;

    /** Location of the Earthquake */
    private String mEarthquakeLocation;

    /** Time of the earthquake */
    private long mTimeInMilliseconds;

    /** Website URL of the earthquake */
    private String mUrl;


    /**
     * Create a new Earthquake object.
     * @param earthquakeMagnitude is the magnitude (size) of the earthquake
     * @param earthquakeLocation is the city location of the earthquake
     * @param timeInMilliseconds is the time in milliseconds (from the Epoch) when the
     * @param url
     */

    public Earthquake(double earthquakeMagnitude, String earthquakeLocation, long timeInMilliseconds, String url) {
        //Initializing the variables
        mEarthquakeMagnitude = earthquakeMagnitude;
        mEarthquakeLocation = earthquakeLocation;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;
    }

    /**
     * Get the EarthquakeMagnitude method
     */

    public double getEarthquakeMagnitude() {
        return mEarthquakeMagnitude;
    }

    /**
     * Get the EarthquakeLocation method
     */

    public String getEarthquakeLocation() {
        return mEarthquakeLocation;
    }

    /**
     * Get the TimeInMilliseconds method
     */

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    /**
     * Returns the website URL to find more information about the earthquake.
     */
    public String getUrl() {
        return mUrl;
    }
}
