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
 * A {@link Fragment} to display a list of SPA to book.
 */
public class SpaFragment extends Fragment {

    public SpaFragment() {
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
        sites.add(new Site(getString(R.string.name_dores), R.drawable.ic_bains_de_dorres,
                getString(R.string.desc_dores), getString(R.string.url_dores)));
        sites.add(new Site(getString(R.string.name_llo), R.drawable.ic_bains_de_llo,
                getString(R.string.desc_llo), getString(R.string.url_llo)));
        sites.add(new Site(getString(R.string.name_chaldette), R.drawable.ic_chaldette,
                getString(R.string.desc_chaldette), getString(R.string.url_chaldette)));
        sites.add(new Site(getString(R.string.name_cieleo), R.drawable.ic_cieleo,
                getString(R.string.desc_cieleo), getString(R.string.url_cieleo)));
        sites.add(new Site(getString(R.string.name_obalia), R.drawable.ic_o_balia,
                getString(R.string.desc_obalia), getString(R.string.url_obalia)));
        sites.add(new Site(getString(R.string.name_sensoria), R.drawable.ic_sensoria,
                getString(R.string.desc_sensoria), getString(R.string.url_sensoria)));

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

                // create a Uri from an intent string. Use the result to create an Intent.
                Uri webpage = Uri.parse(site.getUriString());

                // create an Intent from webpage. Set the action to ACTION_VIEW
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        return rootView;
    }

}
