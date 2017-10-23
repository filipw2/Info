package com.example.filip.info;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.example.filip.info.coin.DatabaseHelper;
import com.example.filip.info.coin.DatabaseManager;

/**
 * Created by Filip on 2017-10-22.
 */

public class InfoApp extends Application {
    private static Context context;
    private static DatabaseHelper dbHelper;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();
        dbHelper = new DatabaseHelper();
        BroadcastRec br = new BroadcastRec();
        IntentFilter intentFilter = new IntentFilter(POWER_SERVICE);
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        this.registerReceiver(br, intentFilter);
        DatabaseManager.initializeInstance(dbHelper);

    }


}