package com.example.filip.info.dual;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.filip.info.R;

/**
 * Created by Filip on 2017-08-08.
 */

public class PortraitDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portrait_detail);

        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.layout.detail_fragment);

        int position = 0;

        Bundle bundle = getIntent().getExtras();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (bundle != null) {
            position = bundle.getInt("Position");
        }

        if (fragment == null) {
            fragment = AddressDetailFragment.getInstance(position);

            fragmentManager.beginTransaction()
                    .add(R.id.detailFragmentHolder, fragment)
                    .commit();
        }
    }
}
