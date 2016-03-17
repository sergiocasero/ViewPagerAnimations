package com.sergiocasero.viewpageranimations.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.sergiocasero.viewpageranimations.R;
import com.sergiocasero.viewpageranimations.adapter.PagerAdapter;
import com.sergiocasero.viewpageranimations.transformer.ViewPagerTransformer;

import butterknife.Bind;

public class MainActivity extends RootActivity {

    @Bind(R.id.viewpager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeUI();
    }

    private void initializeUI() {
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        viewPager.setPageTransformer(false, new ViewPagerTransformer());
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_main;
    }
}
