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
    private String mEarthquakeMagnitude;

    /** Location of the Earthquake */
    private String mEarthquakeLocation;

    /** Date of the Earthquake */
    private String mEarthquakeDate;

    /**
     * Create a new Earthquake object.
     * @param earthquakeMagnitude
     * @param earthquakeLocation
     * @param earthquakeDate
     */

    public Earthquake (String earthquakeMagnitude, String earthquakeLocation, String earthquakeDate) {
        //Initializing the variables
        mEarthquakeMagnitude = earthquakeMagnitude;
        mEarthquakeLocation = earthquakeLocation;
        mEarthquakeDate = earthquakeDate;
    }

    /**
     * Get the EarthquakeMagnitude method
     */

    public String getEarthquakeMagnitude() {
        return mEarthquakeMagnitude;
    }

    /**
     * Get the EarthquakeLocation method
     */

    public String getEarthquakeLocation() {
        return mEarthquakeLocation;
    }

    /**
     * Get the EarthquakeDate method
     */

    public String getEarthquakeDate() {
        return mEarthquakeDate;
    }
}
