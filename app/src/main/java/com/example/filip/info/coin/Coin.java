package com.example.filip.info.coin;

import android.util.Log;

import com.google.gson.annotations.SerializedName;


/**
 * Created by Filip on 2017-07-20.
 */

public class Coin {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("symbol")
    private String symbol;
    @SerializedName("total_supply")
    private Double totalCoinSupply;
    @SerializedName("price_usd")
    private Double price;

    public Coin(String id, String name, String fullName, Double totalCoinSupply, Double price) {
        this.id = id;
        this.name = name;
        this.symbol = fullName;
        this.totalCoinSupply = totalCoinSupply;
        this.price = price;
    }

    public void print() {
        Log.i("Coin", name);
    }

    public Double getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public Double getTotalCoinSupply() {
        return totalCoinSupply;
    }


}
