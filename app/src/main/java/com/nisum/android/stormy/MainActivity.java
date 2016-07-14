package com.nisum.android.stormy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private double latitude;
    private double longitude;
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String apiKey = "8d1c8bed6e1a54a670bf29c94855dbc3";
        latitude = 37.8267 ;
        longitude = -122.423;
        String forecastURL = "https://api.forecast.io/forecast/"+ apiKey+"/"+latitude+","+longitude;

        //creating request
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(forecastURL)
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    if(response.isSuccessful()) {
                        Log.v(TAG, response.body().string());
                    }else {
                        alertUser();
                    }
                } catch (IOException e) {
                    Log.e(TAG,"Exception caught: ", e);
                }
            }
        });
    }

    private void alertUser() {
        AlertDialogFragment dialog = new AlertDialogFragment();
        dialog.show(getFragmentManager(),"error dialog");
    }
}
