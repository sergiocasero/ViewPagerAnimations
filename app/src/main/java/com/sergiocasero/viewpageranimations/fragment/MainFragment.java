package com.sergiocasero.viewpageranimations.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sergiocasero.viewpageranimations.R;

/**
 * Created by sergiocasero on 17/3/16.
 */
public class MainFragment extends Fragment {

    private int page;

    public static MainFragment newInstance(int page) {
        MainFragment fragment = new MainFragment();
        fragment.setPage(page);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        switch (page) {
            case 0:
                return inflater.inflate(R.layout.fragment_one, container, false);
            case 1:
                return inflater.inflate(R.layout.fragment_two, container, false);
            case 2:
                return inflater.inflate(R.layout.fragment_three, container, false);
            default:
                return inflater.inflate(R.layout.fragment_one, container, false);
        }

    }

    public void setPage(int page) {
        this.page = page;
    }
}
