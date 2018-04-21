package com.example.android.riyadhtour;


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
 * A simple {@link Fragment} subclass.
 */
public class MuseumsFragment extends Fragment {


    public MuseumsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(getString(R.string.museum_name_1), getString(R.string.museum_address_1), getString(R.string.museum_working_hours_1), R.drawable.location_museum_1));
        locations.add(new Location(getString(R.string.museum_name_2), getString(R.string.museum_address_2), getString(R.string.museum_working_hours_2), R.drawable.location_museum_2));
        locations.add(new Location(getString(R.string.museum_name_3), getString(R.string.museum_address_3), getString(R.string.museum_working_hours_3), R.drawable.location_museum_3));
        locations.add(new Location(getString(R.string.museum_name_4), getString(R.string.museum_address_4), getString(R.string.museum_working_hours_4), R.drawable.location_museum_4));
        locations.add(new Location(getString(R.string.museum_name_5), getString(R.string.museum_address_5), getString(R.string.museum_working_hours_5), R.drawable.location_museum_5));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);

        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Location location = locations.get(position);

                Uri mapUri = Uri.parse(getString(R.string.address_params) + location.getAddress());
                Intent intent = new Intent(Intent.ACTION_VIEW, mapUri);
                startActivity(intent);

            }
        });

        return rootView;
    }

}
