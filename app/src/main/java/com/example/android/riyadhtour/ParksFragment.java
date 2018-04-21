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
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParksFragment extends Fragment {


    public ParksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location("ALNakeel Park", "7516 Juwairiyah Bint Al Harith, An Nakhil, Riyadh 12381 4610", "Always Open"));
        locations.add(new Location("WORLD SIGHTS PARK Riyadh", "4298 Nasir Ar Rajihi, Al Mughrizat, Riyadh 12482 7164", "3:30PM-11PM"));
        locations.add(new Location("King Abdullah Walkways and Park", "Salah Ad Din, Unnamed Road، Riyadh 12435", "Always Open"));
        locations.add(new Location("King Fahad Garden", "Al Olaya, Riyadh 12211", "8AM-7PM"));
        locations.add(new Location("Prince Abdulaziz Bin Mohammed Bin Ayyaf Park", "Al Hamra, Riyadh 13216", "Always Open"));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);

        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Location location = locations.get(position);

                Uri mapUri = Uri.parse("geo:0,0?q=" + location.getAddress());
                Intent intent = new Intent(Intent.ACTION_VIEW, mapUri);
                startActivity(intent);

            }
        });

        return rootView;
    }

}
