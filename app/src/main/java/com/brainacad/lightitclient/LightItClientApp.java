package com.brainacad.lightitclient;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.brainacad.lightitclient.api.Constants;
import com.brainacad.lightitclient.api.network.ApiService;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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

        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        if(BuildConfig.DEBUG) {
            okHttpBuilder.addInterceptor(loggingInterceptor);
        }

//        okHttpBuilder.addInterceptor(new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//
//                Request request = chain.request();
//                Request.Builder newReq = request.newBuilder().header("Authorization", mSharedPreferences.getString(Constants.TOKEN, null));
//                return chain.proceed(newReq.build());
//            }
//        });


        retrofit = new Retrofit.Builder()
                .baseUrl("http://smktesting.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpBuilder.build())
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

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
