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
public class MuseumsFragment extends Fragment {


    public MuseumsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location("King Abdulaziz Historical Center", "King Faisal Rd، Al Murabba, Riyadh 12631", "8AM-9PM", R.drawable.location_museum_1));
        locations.add(new Location("Royal Saudi Air Force Museum", "Eastern Ring Branch Rd, King Abdullah, Riyadh 12451", "8AM-8PM", R.drawable.location_museum_2));
        locations.add(new Location("Al Masmak Museum", "3153 Al Thumairi St, Ad Dirah, 6937، Riyadh 12634", "8AM-9PM", R.drawable.location_museum_3));
        locations.add(new Location("Murabba Palace", "2722 الملك سعود, Al Murabba, Riyadh 12631", "8AM-9PM", R.drawable.location_museum_4));
        locations.add(new Location("King Salman Science Oasis", "Al Safarat, Riyadh 11693", "8AM-8PM", R.drawable.location_museum_5));

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
