package com.example.filip.info.display;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.filip.info.R;
import com.example.filip.info.coin.Coin;
import com.example.filip.info.coin.ParseJSON;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Filip on 2017-07-20.
 */

public class CoinListActivity extends AppCompatActivity implements OnTaskCompleted {

    List<Coin> coins;
    RecyclerView rvCoins;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_coins);

        rvCoins = (RecyclerView) findViewById(R.id.rvCoins);
        ParseJSON parseJSON = new ParseJSON();
        try {
            parseJSON.getCoins(this);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTaskCompleted(ArrayList arrayList) {
        coins = arrayList;
        setAdapterHandler();
    }

    private void setAdapterHandler() {
        CoinsAdapter adapter = new CoinsAdapter(coins, this);
        rvCoins.setAdapter(adapter);
        rvCoins.setLayoutManager(new LinearLayoutManager(this));
    }
}
