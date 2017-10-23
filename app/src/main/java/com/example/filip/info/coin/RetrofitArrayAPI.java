package com.example.filip.info.coin;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by Filip on 2017-10-23.
 */

public interface RetrofitArrayAPI {
    @GET("/v1/ticker")
    Call<List<Coins>> getCoinsDetails();
}
