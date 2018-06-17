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

        //Find the TextView in the earthquake_list_iteme_list_item.xml layout with the ID location_tv
        TextView dateTextView = listItemView.findViewById(R.id.date_tv);

        //Get the Earthquake from the current Earthquake object and set this text
        //on the magnitudeTextView
        dateTextView.setText(currentEarthquake.getEarthquakeDate());

        //Return the whole listItem layout (containing 2 TextViews)
        //so that it can be shown in the ListView
        return listItemView;
    }
}
