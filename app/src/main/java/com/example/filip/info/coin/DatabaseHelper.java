package com.example.filip.info.coin;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.filip.info.InfoApp;

/**
 * Created by Filip on 2017-10-22.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Crypto.db";
    private static final int DATABASE_VERSION = 8;
    private static final String TAG = DatabaseHelper.class.getSimpleName().toString();

    public DatabaseHelper() {
        super(InfoApp.getContext(), DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.i(TAG, "onCreate");
//        try {
        sqLiteDatabase.execSQL("PRAGMA foreign_keys=ON");
        sqLiteDatabase.execSQL(CoinsRepo.createTable());
//        }catch (SQLException e){
//            Log.e(TAG,e.toString());
//        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}