package com.example.filip.info.view.swipe;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.filip.info.R;

/**
 * Created by Filip on 2017-08-05.
 */

public class DemoFragment extends Fragment {
    private static String TAG = "DemoFragment";
    private String title;
    private int page;

    public static DemoFragment newInstance(int page, String title) {
        DemoFragment fragmentFirst = new DemoFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "in onCreateView");
        Log.i(TAG, "inflater.inflate");
        View rootView = inflater.inflate(R.layout.fragment, container, false);
        Bundle args = getArguments();
        // TextView tvLabel = (TextView) rootView.findViewById(text1);
        // tvLabel.setText(page + " -- " + title);
        Log.i(TAG, "return rootView");
        return rootView;
    }
}
