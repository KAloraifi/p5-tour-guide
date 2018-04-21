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
public class MosquesFragment extends Fragment {


    public MosquesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location("King Khalid Grand Mosque", "Umm Al Hamam St, Umm Al Hamam Al Gharbi، Umm Al Hamam Al Gharbi, Riyadh 12326", "Always Open"));
        locations.add(new Location("Al Rajhi Mosque", "7084 Al Akheyar, Al Jazirah Riyadh 14251 2229", "Always Open"));
        locations.add(new Location("Fahad Al Owaidah Grand Mosque", "King Abdullah Branch Rd, Al Wahah, Riyadh 12445", "Always Open"));
        locations.add(new Location("Princess Latifa Bint Sultan Bin Abdulaziz Grand Mosque", "Takhassusi St, Ar Rahmaniyah, takhsussi 12343, Riyadh 12343", "Always Open"));
        locations.add(new Location("Al Jowharah Grand Mosque", "7110 Uthman Ibn Affan Branch Rd, At Taawun, Riyadh 12476", "Always Open"));

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
