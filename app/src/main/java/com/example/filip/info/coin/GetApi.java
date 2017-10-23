package com.example.filip.info.coin;

import android.graphics.ColorSpace;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by Filip on 2017-10-23.
 */

public interface GetApi {
    @GET("/list")
    Call<ColorSpace.Model> getModel();
}
