package com.example.filip.info.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import com.example.filip.info.R;

public class Demo extends AppCompatActivity {
    private final static String KEY = "DEMO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TextView textView = (TextView) findViewById(R.id.demo_TV);

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        textView.setText(sharedPreferences.getString(KEY, ""));
        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                editor.putString(KEY, s.toString());
                editor.commit();
            }
        });
    }

}
