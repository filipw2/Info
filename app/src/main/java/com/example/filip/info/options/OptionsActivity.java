package com.example.filip.info.options;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.filip.info.R;

/**
 * Created by Filip on 2017-08-04.
 */

public class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_options);

        getFragmentManager().beginTransaction()
                .replace(R.id.preferences_container, new OptionsFragment())
                .commit();


    }
}
