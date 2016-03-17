package com.sergiocasero.viewpageranimations.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sergiocasero.viewpageranimations.fragment.MainFragment;

/**
 * Created by sergiocasero on 17/3/16.
 */
public class PagerAdapter extends FragmentPagerAdapter {
    private static final int PAGE_COUNT = 3;

    public PagerAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        return MainFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
