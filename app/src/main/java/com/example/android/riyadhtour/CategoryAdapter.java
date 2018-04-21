package com.example.android.riyadhtour;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Aloraifi on 20/04/2018.
 */

public class CategoryAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MuseumsFragment();
        } else if (position == 1){
            return new MosquesFragment();
        } else if (position == 2){
            return new MallsFragment();
        } else {
            return new ParksFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_museums);
        } else if (position == 1){
            return mContext.getString(R.string.category_mosques);
        } else if (position == 2){
            return mContext.getString(R.string.category_malls);
        } else {
            return mContext.getString(R.string.category_parks);
        }
    }
}
