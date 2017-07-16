package com.example.android.occitanietourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by guiguette on 04/07/2017.
 * <p>
 * Implement an array adapter of object {@link Site}.
 */

public class SiteAdapter extends ArrayAdapter<Site> {

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context       The current context. Used to inflate the layout file.
     * @param siteArrayList A List of Site objects to display in a list
     */
    public SiteAdapter(Context context, ArrayList<Site> siteArrayList) {
        super(context, 0, siteArrayList);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Site} object located at this position in the list
        Site currentSite = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID site_name
        TextView siteNameTextView = (TextView) listItemView.findViewById(R.id.site_name);
        // Get the site name from the current Site object and
        // set this text on the name TextView
        siteNameTextView.setText(currentSite.getSiteName());

        // Find the ImageView in the list_item.xml layout with the ID site_image
        ImageView siteImageView = (ImageView) listItemView.findViewById(R.id.site_image);
        // Get the image from the current Site object and
        // set this image on the Image View
        siteImageView.setImageResource(currentSite.getPicResourceId());
        // make sure the image view is visible
        siteImageView.setVisibility(View.VISIBLE);

        // Find the TextView in the list_item.xml layout with the ID site_description
        TextView siteDescriptionTextView = (TextView) listItemView.findViewById(R.id.site_description);
        // Get the site description from the current Site object and
        // set this text on the description TextView
        siteDescriptionTextView.setText(currentSite.getSiteDescription());

        return listItemView;
    }


}
