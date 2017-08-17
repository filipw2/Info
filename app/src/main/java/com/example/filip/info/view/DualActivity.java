package com.example.filip.info.view;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;

import com.example.filip.info.R;
import com.example.filip.info.dual.ActivityComs;
import com.example.filip.info.dual.AddressDetailFragment;
import com.example.filip.info.dual.AddressListFragment;
import com.example.filip.info.dual.PortraitDetailActivity;

/**
 * Created by Filip on 2017-08-08.
 */

public class DualActivity extends AppCompatActivity implements ActivityComs {
    private static final String TAG = "DualActivity";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dualfragment);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        FragmentManager fManager = getFragmentManager();

        Fragment frag = fManager.findFragmentById(R.id.listFragmentHolder);

        if (frag == null) {
            frag = new AddressListFragment();
            fManager.beginTransaction()
                    .add(R.id.listFragmentHolder, frag)
                    .commit();
        }

    }

    @Override
    public void onListItemSelected(int position) throws NullPointerException {
        try {


            if (findViewById(R.id.detailFragmentHolder) == null) {

                Intent i = new Intent(this, PortraitDetailActivity.class);

                i.putExtra("Position", position);

                startActivity(i);

            } else {

                FragmentManager fManager = getFragmentManager();
                FragmentTransaction fTransaction = fManager.beginTransaction();

                Fragment fragOld = fManager.findFragmentById(R.id.detailFragmentHolder);
                Fragment fragNew = AddressDetailFragment.getInstance(position);

                if (fragOld != null) {
                    fTransaction.remove(fragOld);
                }

                fTransaction.add(R.id.detailFragmentHolder, fragNew);
                fTransaction.commit();
            }
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_info, menu);
        return true;
    }
}
