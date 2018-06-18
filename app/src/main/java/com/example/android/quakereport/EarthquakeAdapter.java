package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * {@link EarthquakeAdapter} knows how to create a list item layout for each earthquake
 * in the data source (a list of {@link Earthquake} objects).
 *
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake>{

    /**
     * Constructs a new {@link EarthquakeAdapter}.
     *
     * @param context of the app
     * @param earthquakes is the list of earthquakes, which is the data source of the adapter
     */


    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes) {
        //Here I initialize the ArrayAdapter's internal storage for the context and the list.
        //The second argument is used when the ArrayAdapter is populating a single TextView.
        //Because, this is a custom adapter for two TextViews, the adapter is not going to
        //use this second argument, so it can be any value.  Here I use 0.
        super(context, 0, earthquakes);
    }

    /**
     * Provides a View of an AdapterView (ListView, GridView, etc.)
     * @param position The position is the list of data that should be displayed
     *                 in the listItemView
     * @param convertView The recycledView to populate
     * @param parent The parent ViewGroup that is used for inflation
     * @return The View for the position in the AdapterView.
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Check if the existing View is being reused, otherwise inflate the View
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent,
                    false);
        }

        //Get the {@link Earthquake} object located at this position in the list
        Earthquake currentEarthquake = getItem(position);

        //Find the TextView in the earthquake_list_item.xmlst_item.xml layout with the ID magnitude_tv
        TextView magnitudeTextView = listItemView.findViewById(R.id.magnitude_tv);
        //Get the Earthquake from the current Earthquake object and set this text
        //on the magnitudeTextView
        magnitudeTextView.setText(currentEarthquake.getEarthquakeMagnitude());

        //Find the TextView in the earthquake_list_item.xmlst_item.xml layout with the ID location_tv
        TextView locationTextView = listItemView.findViewById(R.id.location_tv);
        //Get the Earthquake from the current Earthquake object and set this text
        //on the magnitudeTextView
        locationTextView.setText(currentEarthquake.getEarthquakeLocation());

        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

        //Find the TextView in the earthquake_list_iteme_list_item.xml layout with the ID location_tv
        TextView dateTextView = listItemView.findViewById(R.id.date_tv);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateTextView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = listItemView.findViewById(R.id.time_tv);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);


        //Return the whole listItem layout (containing 4 TextViews)
        //so that it can be shown in the ListView
        return listItemView;

    }

//    /**
//     * First convert the time in milliseconds into a Date object by calling the Date constructor.
//     */
//
//    long timeInMilliseconds = 1454124312220L;
//    Date dateObject = new Date(timeInMilliseconds);
//
//    /**
//     * Then we can initialize a SimpleDateFormat instance and configure it to provide a more
//     * readable representation according to the given format.
//     */
//
//    SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
//    String dateToDisplay = dateFormatter.format(dateObject);

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

}
