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
 * A {@link Fragment} to display a list of nice spots in nature to visit.
 */
public class NatureFragment extends Fragment {

    public NatureFragment() {
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
        sites.add(new Site(getString(R.string.name_barroude), R.drawable.ic_cirque_de_barroude,
                getString(R.string.desc_barroude), getString(R.string.geo_barroude)));
        sites.add(new Site(getString(R.string.name_padirac), R.drawable.ic_gouffre_padirac,
                getString(R.string.desc_padirac), getString(R.string.geo_padirac)));
        sites.add(new Site(getString(R.string.name_niaux), R.drawable.ic_grotte_niaux,
                getString(R.string.desc_niaux), getString(R.string.geo_niaux)));
        sites.add(new Site(getString(R.string.name_pech), R.drawable.ic_grotte_pech_merle,
                getString(R.string.desc_pech), getString(R.string.geo_pech)));
        sites.add(new Site(getString(R.string.name_midi), R.drawable.ic_pic_midi,
                getString(R.string.desc_midi), getString(R.string.geo_midi)));
        sites.add(new Site(getString(R.string.name_sidobre), R.drawable.ic_sidobre_rocks,
                getString(R.string.desc_sidobre), getString(R.string.geo_sidobre)));

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
