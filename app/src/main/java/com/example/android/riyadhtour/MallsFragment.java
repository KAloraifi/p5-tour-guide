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
public class MallsFragment extends Fragment {


    public MallsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location("Al Nakheel Mall", "2976 Exit 9, Al Imam Saud Ibn Abdul Aziz Branch Road, Mugharazat District، Al Mughrizat, Riyadh 12483", "9:30AM-11PM", R.drawable.location_mall_1));
        locations.add(new Location("Centria Mall", "Olaya St, Al Olaya, Riyadh 12241", "10AM-10:30PM", R.drawable.location_mall_2));
        locations.add(new Location("Riyadh Gallery", "262 King Fahd Rd, King Fahd, Riyadh 12262", "8AM-12AM", R.drawable.location_mall_3));
        locations.add(new Location("Hayat Mall", "King Abdul Aziz Rd, King Fahd, Riyadh 12272", "8AM-1AM", R.drawable.location_mall_4));
        locations.add(new Location("Granada Center", "Eastern Ring Branch Rd, Exit 9, Ash Shuhada District، Ash Shuhada, Riyadh 13241", "9AM-11PM", R.drawable.location_mall_5));

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
