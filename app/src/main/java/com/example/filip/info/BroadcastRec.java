package com.example.filip.info;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Filip on 2017-10-23.
 */

public class BroadcastRec extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Power connected", Toast.LENGTH_SHORT).show();
        Log.i("BReciver", "onReceive: ");
    }
}
