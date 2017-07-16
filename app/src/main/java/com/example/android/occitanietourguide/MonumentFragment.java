package com.example.android.occitanietourguide;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A {@link Fragment} to display the list of monuments.
 */
public class MonumentFragment extends Fragment {


    public MonumentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate site_list layout when this fragment is called
        View rootView = inflater.inflate(R.layout.site_list, container, false);

        // create a new ArrayList of {@link Site}
        final ArrayList<Site> sites = new ArrayList<>();

        // populate this ArrayList
        sites.add(new Site(getString(R.string.name_arena_nimes), R.drawable.ic_arena_nimes,
                getString(R.string.desc_arena_nimes), getString(R.string.geo_arena_nimes)));
        sites.add(new Site(getString(R.string.name_capitol), R.drawable.ic_capitol_of_toulouse,
                getString(R.string.desc_capitol), getString(R.string.geo_capitol)));
        sites.add(new Site(getString(R.string.name_carcassonne), R.drawable.ic_carcassonne_city,
                getString(R.string.desc_carcassonne), getString(R.string.geo_carcassonne)));
        sites.add(new Site(getString(R.string.name_albi), R.drawable.ic_cathedral_albi,
                getString(R.string.desc_albi), getString(R.string.geo_albi)));
        sites.add(new Site(getString(R.string.name_montsegur), R.drawable.ic_montsegur,
                getString(R.string.desc_montsegur), getString(R.string.geo_montsegur)));
        sites.add(new Site(getString(R.string.name_lourdes), R.drawable.ic_notre_dame_de_lourdes,
                getString(R.string.desc_lourdes), getString(R.string.geo_lourdes)));
        sites.add(new Site(getString(R.string.name_st_guilhem), R.drawable.ic_saint_guilhem_le_desert,
                getString(R.string.desc_st_guilhem), getString(R.string.geo_st_guilhem)));

        // create a Site adapter
        SiteAdapter adapter = new SiteAdapter(getActivity(), sites);

        // find the ListView
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // set the adapter onto the ListView so that it displays data fed by the adapter
        listView.setAdapter(adapter);

        // set an OnClickItemListener on to the listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // get the Site object at the given position the user clicked on
                Site site = sites.get(position);

                // Create a Uri from an intent string. Use the result to create an Intent.
                Uri gmmIntentUri = Uri.parse(site.getUriString());

                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

                // Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");

                // Attempt to start an activity that can handle the Intent
                if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });

        return rootView;
    }

}
