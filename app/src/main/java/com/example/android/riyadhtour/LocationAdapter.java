package com.example.android.riyadhtour;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Aloraifi on 20/04/2018.
 */

public class LocationAdapter extends ArrayAdapter<Location> {
    private Context mContext;

    public LocationAdapter(Context context, ArrayList<Location> locations) {
        super(context, 0, locations);
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Location currentLocation = getItem(position);

        TextView name = listItemView.findViewById(R.id.list_item_name);
        name.setText(currentLocation.getName());

        TextView workingHours = listItemView.findViewById(R.id.list_item_working_hours);
        workingHours.setText(mContext.getString(R.string.working_hours, currentLocation.getWorkingHours()));
        if (currentLocation.getWorkingHours().equals("Always Open")) {
            workingHours.setTextColor(Color.parseColor(mContext.getString(R.string.open_indication_color)));
        }

        ImageView image = listItemView.findViewById(R.id.list_item_image);

        if (currentLocation.hasImage()) {
            // Set the image and show it.
            image.setImageResource(currentLocation.getImageResourceId());
            image.setVisibility(View.VISIBLE);
        } else {
            // Hide the image element.
            image.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
