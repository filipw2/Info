package com.example.filip.info.coin;

import android.os.AsyncTask;
import android.util.Log;

import com.example.filip.info.main.KotlinActivity;
import com.example.filip.info.view.OnTaskCompleted;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

/**
 * Created by Filip on 2017-07-19.
 */

public class ParseJSON {
    private static String TAG = "ParseJSON";
    private Coin[] coins;

    public static String streamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        Log.i(TAG, "streamToString");
        try {

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }

            reader.close();

        } catch (IOException e) {
            Log.d(ParseJSON.class.getSimpleName(), e.toString());
        }

        return stringBuilder.toString();
    }

    public void getCoins(OnTaskCompleted listener) throws ExecutionException, InterruptedException {

        StringBuilder sb = new StringBuilder();
        sb.append("https://api.coinmarketcap.com/v1/ticker");

        //sb.append("&format=json");
        String message = sb.toString();
        Log.i(TAG, "msg" + message);


        new WebServiceHandler(listener).execute(message);


    }

    private class WebServiceHandler extends AsyncTask<String, ArrayList, String> {

        private OnTaskCompleted listener;

        public WebServiceHandler(OnTaskCompleted onTaskCompleted) {
            listener = onTaskCompleted;
        }


        @Override
        protected void onPreExecute() {


        }


        @Override
        protected String doInBackground(String... urls) {

            try {
                URL url = new URL(urls[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                Log.i(TAG, "openConnection");

                InputStream in = new BufferedInputStream(
                        connection.getInputStream());

                Log.i(TAG, "return input");
                return streamToString(in);

            } catch (Exception e) {
                Log.d(KotlinActivity.class.getSimpleName(), e.toString());
                return null;
            }

        }

        @Override
        protected void onPostExecute(String result) {
            //Log.i(TAG, "r: " + result);
            try {

                Log.i(TAG, "new JSON");
                JSONArray jsonArray = new JSONArray(result);

                Gson gson = new Gson();
                coins = gson.fromJson(result, Coin[].class);

                listener.onTaskCompleted(new ArrayList<>(Arrays.asList(coins)));

                // Log.i(TAG,json.toString());

            } catch (Exception e) {
                Log.d(ParseJSON.class.getSimpleName(), "exception: " + e.toString());
            }
        }
    }

}
