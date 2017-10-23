package com.example.filip.info.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

import com.example.filip.info.OnlineChecker;
import com.example.filip.info.R;
import com.example.filip.info.coin.Coins;
import com.example.filip.info.coin.CoinsRepo;
import com.example.filip.info.coin.ParseJSON;
import com.example.filip.info.coin.RetrofitCoins;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Filip on 2017-07-20.
 */

public class CoinListActivity extends AppCompatActivity implements OnTaskCompleted {

    List<Coins> coins;
    RecyclerView rvCoins;
    ParseJSON parseJSON;
    Boolean permissionGranted = true;
    CoinsRepo mCoinsRepo;
    CoinsAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_coins);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mCoinsRepo = CoinsRepo.getInstance();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        rvCoins = (RecyclerView) findViewById(R.id.rvCoins);
        setAdapterHandler();
        adapter.setCoins(mCoinsRepo.getCoinsArrayList());
        //parseJSON();
        RetrofitCoins retrofitCoins = new RetrofitCoins();
        retrofitCoins.getRetrofitArray();
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }

    private void parseJSON() {


        parseJSON = new ParseJSON();
        try {
            Dexter.withActivity(this)
                    .withPermission(android.Manifest.permission.INTERNET)
                    .withListener(new PermissionListener() {
                        @Override
                        public void onPermissionGranted(PermissionGrantedResponse response) {
                            permissionGranted = true;
                        }

                        @Override
                        public void onPermissionDenied(PermissionDeniedResponse response) {
                            permissionGranted = false;
                        }

                        @Override
                        public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {

                        }
                    }).check();
            Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show();

            new OnlineChecker().isOnline(this);
            if (permissionGranted) parseJSON.getCoins(this);

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTaskCompleted(ArrayList arrayList) {
        coins = arrayList;
        mCoinsRepo.insertMultiple(arrayList);
        adapter.setCoins(arrayList);
        adapter.notifyDataSetChanged();

    }

    private void setAdapterHandler() {
        adapter = new CoinsAdapter(coins, this);
        rvCoins.setAdapter(adapter);
        rvCoins.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_info, menu);
        return true;

    }
}
