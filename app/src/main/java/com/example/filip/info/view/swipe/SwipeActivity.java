package com.example.filip.info.view.swipe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.Toast;

import com.example.filip.info.R;

/**
 * Created by Filip on 2017-08-05.
 */

public class SwipeActivity extends FragmentActivity {
    private static String TAG = "SwipeActivity";

    DemoFragmentPageAdapter demoFragmentPageAdapter;
    ViewPager viewPager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.i(TAG, "in onCreate");
        setContentView(R.layout.activity_swipe);

        Log.i(TAG, "new adapter");
        demoFragmentPageAdapter = new DemoFragmentPageAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.pager);
        Log.i(TAG, "setAdapter");
        viewPager.setAdapter(demoFragmentPageAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {
                Toast.makeText(SwipeActivity.this,
                        "Selected page position: " + position, Toast.LENGTH_SHORT).show();
            }

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Code goes here
            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {
                // Code goes here
            }
        });

    }


}
