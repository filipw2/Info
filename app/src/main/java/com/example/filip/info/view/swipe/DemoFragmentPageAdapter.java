package com.example.filip.info.view.swipe;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

/**
 * Created by Filip on 2017-08-05.
 */

public class DemoFragmentPageAdapter extends FragmentPagerAdapter {
    private static String TAG = "DemoFragmentPageAdapter";
    private static int NUM_ITEMS = 3;

    public DemoFragmentPageAdapter(FragmentManager fm) {
        super(fm);
        Log.i(TAG, "in constructor");
    }

    @Override
    public Fragment getItem(int position) {

        Log.i(TAG, "in getItem");
        switch (position) {
            case 0:
                return DemoFragment.newInstance(0, "Page # 1");
            case 1:
                return DemoFragment.newInstance(1, "Page # 2");
            case 2:
                return DemoFragment.newInstance(2, "Page # 3");
            default:
                return null;
        }
    }

    @Override
    public int getCount() {

        Log.i(TAG, "in getCount");
        return NUM_ITEMS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Log.i(TAG, "in getPageTitle");
        return "page " + position;
    }
}
