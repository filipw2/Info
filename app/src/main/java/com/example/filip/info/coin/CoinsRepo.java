package com.example.filip.info.coin;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Filip on 2017-10-22.
 */

public class CoinsRepo {
    public static final String TAG = CoinsRepo.class.getSimpleName();
    private static final CoinsRepo mCoinsRepo = new CoinsRepo();
    private Coins mCoins;

    public CoinsRepo() {
        this.mCoins = new Coins();
    }

    public static CoinsRepo getInstance() {
        return mCoinsRepo;
    }

    public static String createTable() {
        Log.i(TAG, "createTable");
        String query;
        query = "CREATE TABLE " + Coins.TABLE + "("
                + Coins.KEY_ID_COINS + " TEXT PRIMARY KEY," + Coins.KEY_NAME + " text NOT NULL," + Coins.KEY_SYMBOL + " text NOT NULL UNIQUE,"
                + Coins.KEY_RANK + " text," + Coins.KEY_PRICE_USD + " text," + Coins.KEY_PRICE_BTC + " text,"
                + Coins.KEY_24H_VOLUME_USD + " text," + Coins.KEY_AVAILABLE_SUPPLY + " text," + Coins.KEY_TOTAL_SUPPLY + " text,"
                + Coins.KEY_PERCENT_CHANGE_1h + " text," + Coins.KEY_PERCENT_CHANGE_24h + " text," + Coins.KEY_PERCENT_CHANGE_7D + " text,"
                + Coins.KEY_LAST_UPDATED + " text)";
        Log.i(TAG, query);
        return query;
    }

    public int insert(Coins coins) {
        int coinsId;
        SQLiteDatabase database = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();

        values.put(Coins.KEY_ID_COINS, coins.getIdCoins());
        values.put(Coins.KEY_NAME, coins.getName());
        values.put(Coins.KEY_SYMBOL, coins.getSymbol());
        values.put(Coins.KEY_RANK, coins.getRank());
        values.put(Coins.KEY_PRICE_USD, coins.getPrice_usd());
        values.put(Coins.KEY_PRICE_BTC, coins.getPrice_btc());
        values.put(Coins.KEY_24H_VOLUME_USD, coins.getVolume_usd());
        values.put(Coins.KEY_AVAILABLE_SUPPLY, coins.getAvailable_supply());
        values.put(Coins.KEY_TOTAL_SUPPLY, coins.getTotal_supply());
        values.put(Coins.KEY_PERCENT_CHANGE_1h, coins.getPercent_change_1h());
        values.put(Coins.KEY_PERCENT_CHANGE_24h, coins.getPercent_change_24h());
        values.put(Coins.KEY_PERCENT_CHANGE_7D, coins.getPercent_change_7d());
        values.put(Coins.KEY_LAST_UPDATED, coins.getLast_updated());

        coinsId = (int) database.insert(Coins.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();

        return coinsId;
    }

    public void insertMultiple(ArrayList<Coins> coinsArrayList) {
        new AsyncTask<ArrayList<Coins>, Void, Void>() {
            @Override
            protected Void doInBackground(ArrayList<Coins>... coinsArrayList) {
                Log.i(TAG, "doInBackground: ");
                SQLiteDatabase database = DatabaseManager.getInstance().openDatabase();
                ContentValues values = new ContentValues();
                for (Coins coins : coinsArrayList[0]) {
                    values.clear();
                    values.put(Coins.KEY_ID_COINS, coins.getIdCoins());
                    values.put(Coins.KEY_NAME, coins.getName());
                    values.put(Coins.KEY_SYMBOL, coins.getSymbol());
                    values.put(Coins.KEY_RANK, coins.getRank());
                    values.put(Coins.KEY_PRICE_USD, coins.getPrice_usd());
                    values.put(Coins.KEY_PRICE_BTC, coins.getPrice_btc());
                    values.put(Coins.KEY_24H_VOLUME_USD, coins.getVolume_usd());
                    values.put(Coins.KEY_AVAILABLE_SUPPLY, coins.getAvailable_supply());
                    values.put(Coins.KEY_TOTAL_SUPPLY, coins.getTotal_supply());
                    values.put(Coins.KEY_PERCENT_CHANGE_1h, coins.getPercent_change_1h());
                    values.put(Coins.KEY_PERCENT_CHANGE_24h, coins.getPercent_change_24h());
                    values.put(Coins.KEY_PERCENT_CHANGE_7D, coins.getPercent_change_7d());
                    values.put(Coins.KEY_LAST_UPDATED, coins.getLast_updated());
                    database.replace(Coins.TABLE, null, values);
                }
                return null;
            }


        }.execute(coinsArrayList);
        // DatabaseManager.getInstance().closeDatabase();
    }

    public ArrayList<Coins> getCoinsArrayList() {
        Log.i(TAG, "getCoinsArrayList: ");
        SQLiteDatabase database = DatabaseManager.getInstance().openDatabase();
        ArrayList<Coins> coinsArrayList = new ArrayList<>();
        Cursor cursor;
        String query = "SELECT * FROM " + Coins.TABLE + " ORDER BY CAST( " + Coins.KEY_RANK + " as integer )";
        cursor = database.rawQuery(query, null);
        Log.i(TAG, "getCoinsArrayList: " + cursor.getCount());
        if (cursor.moveToFirst()) {

            do {
                Coins coin = new Coins();
                coin.setIdCoins(cursor.getString(0));
                coin.setName(cursor.getString(1));
                coin.setSymbol(cursor.getString(2));
                coin.setRank(cursor.getString(3));
                coin.setPrice_usd(cursor.getString(4));
                coin.setPercent_change_24h(cursor.getString(10));
                coinsArrayList.add(coin);
            } while (cursor.moveToNext());
        }
        cursor.close();


        return coinsArrayList;
    }

    public void delete() {
        SQLiteDatabase database = DatabaseManager.getInstance().openDatabase();
        database.delete(Coins.TABLE, null, null);
        DatabaseManager.getInstance().closeDatabase();
    }


}
