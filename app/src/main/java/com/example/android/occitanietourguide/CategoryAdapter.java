package com.example.android.occitanietourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Provide the appropriate fragment for a view pager
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    /**
     * Context of the app
     */
    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MonumentFragment();
        } else if (position == 1) {
            return new VineyardFragment();
        } else if (position == 2) {
            return new SpaFragment();
        } else {
            return new NatureFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_monument);
        } else if (position == 1) {
            return mContext.getString(R.string.category_vineyard);
        } else if (position == 2) {
            return mContext.getString(R.string.category_spa);
        } else {
            return mContext.getString(R.string.category_nature);
        }
    }
}
