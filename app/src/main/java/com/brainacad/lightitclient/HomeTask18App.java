package com.brainacad.lightitclient;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeTask18App extends Application {

    private ApiService service;
    private Retrofit retrofit;
    private static HomeTask18App appInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = this;
        retrofit = new Retrofit.Builder()
                .baseUrl("http://smktesting.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(ApiService.class);

    }

    public static HomeTask18App getAppInstance() {
        return appInstance;
    }

    public ApiService getService() {
        return service;
    }
}
