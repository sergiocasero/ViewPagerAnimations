package com.sergiocasero.viewpageranimations.transformer;

import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sergiocasero.viewpageranimations.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sergiocasero on 17/3/16.
 */
public class ViewPagerTransformer implements ViewPager.PageTransformer {

    // First Fragment Views
    @Nullable
    @Bind(R.id.fragment1_container)
    RelativeLayout container1;

    @Nullable
    @Bind(R.id.viewpager_title)
    TextView viewPagerTitle;


    // Second Fragment Views
    @Nullable
    @Bind(R.id.fragment2_container)
    RelativeLayout container2;

    @Nullable
    @Bind(R.id.watch)
    ImageView watch;

    @Nullable
    @Bind(R.id.second)
    ImageView second;

    @Nullable
    @Bind(R.id.minute)
    ImageView minute;

    @Nullable
    @Bind(R.id.hour)
    ImageView hour;


    // Third Fragment Views
    @Nullable
    @Bind(R.id.fragment3_container)
    RelativeLayout container3;

    @Nullable
    @Bind(R.id.text3)
    TextView text3;

    private int width;

    private int height;


    @Override
    public void transformPage(View page, float position) {

        width = page.getWidth();
        height = page.getHeight();
        ButterKnife.bind(this, page);


        if (position < -1) {

        } else if (position < 1) {
            if (container1 != null) {
                animateFragment1(position);

            } else if (container2 != null) {
                animateFragment2(position);

            } else if (container3 != null) {
                animateFragment3(position);

            }
        } else {

        }
    }

    private void animateFragment1(float position) {
        viewPagerTitle.setTranslationY((position) * (height));
    }

    private void animateFragment2(float position) {
        watch.setScaleX(-position + 1.0f);
        watch.setScaleY(-position + 1.0f);


        animateImage(hour, position, 500);
        animateImage(minute, position, 1000);
        animateImage(second, position, 1500);
    }

    private void animateImage(ImageView imageView, float position, int coeficient) {
        imageView.setRotation(position * coeficient);
        imageView.setScaleX(-position + 1.0f);
        imageView.setScaleY(-position + 1.0f);
    }

    private void animateFragment3(float position) {
        text3.setTranslationY((position) * (height));
        text3.setTranslationX((-position) * (width));
    }
}
