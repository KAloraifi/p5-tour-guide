package com.example.android.riyadhtour;

/**
 * Created by Aloraifi on 20/04/2018.
 */

public class Location {
    private String mName;
    private String mAddress;
    private String mWorkingHours;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    // Constructor for a location that has no image.
    public Location(String name, String address, String workingHours) {
        mName = name;
        mAddress = address;
        mWorkingHours = workingHours;
    }

    // Constructor for a location that has an image
    public Location(String name, String address, String workingHours, int imageResourceId) {
        mName = name;
        mAddress = address;
        mWorkingHours = workingHours;
        mImageResourceId = imageResourceId;
    }

    public String getName() {
        return mName;
    }

    public String getAddress() {
        return mAddress;
    }

    public String getWorkingHours() {
        return mWorkingHours;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    // Returns true if the location has an image.
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
