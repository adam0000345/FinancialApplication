package com.example.finance.googlesheetsexample.androidlabs.gsheets1;


import android.support.annotation.NonNull;
import android.util.Log;

import com.example.finance.googlesheetsexample.util.Keys;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


public class JSONparser {

    private static final String MAIN_URL = "https://script.google.com/macros/s/AKfycbxw1d75kBSs7cPNPI0hlUSdwUrLNpfGw0eLUKkMjQitesAa7kfz/exec";

    public static final String TAG = "TAG";

    private static Response response;

    private static final String myAPIKey = "";

    public static JSONObject getDataFromWeb() {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(MAIN_URL)
                    .build();
            response = client.newCall(request).execute();
            JSONObject test = new JSONObject(response.body().string());
            return test;

        } catch (@NonNull IOException | JSONException e) {
            Log.e(TAG, "" + e.getLocalizedMessage());
        }
        return null;
    }

    public static JSONObject getDataByStockSymbol(String stocksymbol, String modelType) {

        final String MAIN_URL = "https://script.google.com/macros/s/AKfycbzum_eIP1hMeE58ct1Y-l7WtXkN5-0sLxD6N1kZcxUXXFa_vwzr/exec";

        String id= "1GYqw7C2fMv0qaPvrwnddtbwI1f4zRDh_9Fj-xyhV1gg";

        try {
            OkHttpClient client = new OkHttpClient();




            Request request = new Request.Builder()
                    .url(MAIN_URL+"?"+(Keys.KEY_STOCKSYMBOL + "=" + stocksymbol + "&") +
                            (Keys.KEY_MODELTYPE + "=" + modelType + "&") + ("id" + "=" + id)).get()
                    .build();

            System.out.println("REQUEST "+ request);

            //info: Look into why calls to Google Sheets API can take a while and it
            // does not stop at Terminal Value when it should
            response = client.newCall(request).execute();
            System.out.printf("TEST" + response.toString());
            return new JSONObject(response.body().string());

        } catch (IOException | JSONException e) {
            Log.e(TAG, "" + e.getLocalizedMessage());
        }
        return null;
    }
}