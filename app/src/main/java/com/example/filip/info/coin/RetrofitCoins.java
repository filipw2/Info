package com.example.filip.info.coin;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Filip on 2017-10-23.
 */

public class RetrofitCoins {
    String mBaseUrl;

    public RetrofitCoins() {
        mBaseUrl = "https://api.coinmarketcap.com";
    }

    public void getRetrofitArray() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitArrayAPI service = retrofit.create(RetrofitArrayAPI.class);

        Call<List<Coins>> call = service.getCoinsDetails();

        call.enqueue(new Callback<List<Coins>>() {
            @Override
            public void onResponse(Response<List<Coins>> response, Retrofit retrofit) {

                List<Coins> coins = response.body();
                CoinsRepo.getInstance().insertMultiple((ArrayList<Coins>) coins);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}
