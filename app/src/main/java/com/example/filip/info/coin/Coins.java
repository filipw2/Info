package com.example.filip.info.coin;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Filip on 2017-10-22.
 */

public class Coins {

    public static final String TAG = Coins.class.getSimpleName();
    public static final String TABLE = "Coins";
    public static final String KEY_ID_COINS = " IdCoins";
    public static final String KEY_NAME = "name";
    public static final String KEY_SYMBOL = "symbol";
    public static final String KEY_RANK = "rank";
    public static final String KEY_PRICE_USD = "price_usd";
    public static final String KEY_PRICE_BTC = "price_btc";
    public static final String KEY_24H_VOLUME_USD = "volume_usd";
    public static final String KEY_AVAILABLE_SUPPLY = "available_supply";
    public static final String KEY_TOTAL_SUPPLY = "total_supply";
    public static final String KEY_PERCENT_CHANGE_1h = "percent_change_1h";
    public static final String KEY_PERCENT_CHANGE_24h = "percent_change_24h";
    public static final String KEY_PERCENT_CHANGE_7D = "percent_change_7d";
    public static final String KEY_LAST_UPDATED = "last_updated";

    @SerializedName("id")
    private String idCoins;
    @SerializedName("name")
    private String name;
    @SerializedName("symbol")
    private String symbol;
    @SerializedName("rank")
    private String rank;
    @SerializedName("price_usd")
    private String price_usd;
    @SerializedName("price_btc")
    private String price_btc;
    @SerializedName("24h_volume_usd")
    private String volume_usd;
    @SerializedName("available_supply")
    private String available_supply;
    @SerializedName("total_supply")
    private String total_supply;
    @SerializedName("percent_change_1h")
    private String percent_change_1h;
    @SerializedName("percent_change_24h")
    private String percent_change_24h;
    @SerializedName("percent_change_7d")
    private String percent_change_7d;
    @SerializedName("last_updated")
    private String last_updated;

    public String getIdCoins() {
        return idCoins;
    }

    public void setIdCoins(String idCoins) {
        this.idCoins = idCoins;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPrice_usd() {
        return price_usd;
    }

    public void setPrice_usd(String price_usd) {
        this.price_usd = price_usd;
    }

    public String getPrice_btc() {
        return price_btc;
    }

    public void setPrice_btc(String price_btc) {
        this.price_btc = price_btc;
    }

    public String getVolume_usd() {
        return volume_usd;
    }

    public void setVolume_usd(String volume_usd) {
        this.volume_usd = volume_usd;
    }

    public String getAvailable_supply() {
        return available_supply;
    }

    public void setAvailable_supply(String available_supply) {
        this.available_supply = available_supply;
    }

    public String getTotal_supply() {
        return total_supply;
    }

    public void setTotal_supply(String total_supply) {
        this.total_supply = total_supply;
    }

    public String getPercent_change_1h() {
        return percent_change_1h;
    }

    public void setPercent_change_1h(String percent_change_1h) {
        this.percent_change_1h = percent_change_1h;
    }

    public String getPercent_change_24h() {
        return percent_change_24h;
    }

    public void setPercent_change_24h(String percent_change_24h) {
        this.percent_change_24h = percent_change_24h;
    }

    public String getPercent_change_7d() {
        return percent_change_7d;
    }

    public void setPercent_change_7d(String percent_change_7d) {
        this.percent_change_7d = percent_change_7d;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }
}
