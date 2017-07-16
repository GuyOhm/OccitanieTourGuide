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
 * A {@link Fragment} to display a list of vineyards to visit.
 */
public class VineyardFragment extends Fragment {

    public VineyardFragment() {
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
        sites.add(new Site(getString(R.string.name_cazes), R.drawable.ic_cazes,
                getString(R.string.desc_cazes), getString(R.string.url_cazes)));
        sites.add(new Site(getString(R.string.name_ou), R.drawable.ic_chateau_de_l_ou,
                getString(R.string.desc_ou), getString(R.string.url_ou)));
        sites.add(new Site(getString(R.string.name_py), R.drawable.ic_logo_domaine_py,
                getString(R.string.desc_py), getString(R.string.url_py)));
        sites.add(new Site(getString(R.string.name_jougla), R.drawable.ic_vin_bio,
                getString(R.string.desc_jougla), getString(R.string.url_jougla)));
        sites.add(new Site(getString(R.string.name_anhel), R.drawable.ic_vin_bio,
                getString(R.string.desc_anhel), getString(R.string.url_anhel)));
        sites.add(new Site(getString(R.string.name_jarres), R.drawable.ic_vin_bio,
                getString(R.string.desc_jarres), getString(R.string.url_jarres)));

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
