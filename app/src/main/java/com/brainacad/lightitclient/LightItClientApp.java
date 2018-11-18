package com.brainacad.lightitclient;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.brainacad.lightitclient.api.network.ApiService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LightItClientApp extends Application {

    private ApiService service;
    private Retrofit retrofit;
    private static LightItClientApp appInstance;
    private SharedPreferences mSharedPreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = this;
        initializeService();
        initializePreference();
    }

    private void initializePreference() {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    }

    private void initializeService() {
        OkHttpClient.Builder okHttp = new OkHttpClient.Builder();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);

        if(BuildConfig.DEBUG){
            okHttp.addInterceptor(loggingInterceptor);
        }

        retrofit = new Retrofit.Builder()
                .baseUrl("http://smktesting.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                //.client(okHttp.build())
                .build();
        service = retrofit.create(ApiService.class);
    }

    public static LightItClientApp getAppInstance() {
        return appInstance;
    }

    public ApiService getService() {
        return service;
    }

    public SharedPreferences getSharedPreferences() {
        return mSharedPreferences;
    }
}
