package com.brainacad.lightitclient.api.network;

import android.util.Log;

import com.brainacad.lightitclient.LightItClientApp;
import com.brainacad.lightitclient.api.Constants;
import com.brainacad.lightitclient.api.models.ResProduct;
import com.brainacad.lightitclient.api.models.ResProductComment;
import com.brainacad.lightitclient.api.models.auth.ReqAuthorization;
import com.brainacad.lightitclient.api.models.auth.ResAuthorization;
import com.brainacad.lightitclient.api.models.comm.ReqComment;
import com.brainacad.lightitclient.api.models.comm.ResComment;
import com.brainacad.lightitclient.api.models.regist.ReqRegistration;
import com.brainacad.lightitclient.api.models.regist.ResRegistration;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiManager {
    private LightItClientApp mApp = LightItClientApp.getAppInstance();
    private ApiService mService;

    public ApiManager() {
        this.mService = LightItClientApp.getAppInstance().getService();
    }

    public interface OnProductResponse {
        void onProductRes(List<ResProduct> list);
    }

    public void registration(ReqRegistration user) {
        Call<ResRegistration> resRegistrationCall = mService.registration(user);
        resRegistrationCall.enqueue(new Callback<ResRegistration>() {
            @Override
            public void onResponse(Call<ResRegistration> call, Response<ResRegistration> response) {
                if (response.isSuccessful()) {
                    ResRegistration resRegistration = response.body();

                    Log.d(Constants.TAG, "onResponse: " + resRegistration);

                    mApp.getSharedPreferences()
                            .edit()
                            .putString("token", resRegistration.getToken())
                            .putBoolean("success", resRegistration.isSuccess())
                            .apply();
                }else {
                    Log.d(Constants.TAG, "onResponse: " + call.request() + " " + response.message() + " " + response.errorBody());
                }

            }

            @Override
            public void onFailure(Call<ResRegistration> call, Throwable t) {
                Log.d(Constants.TAG, "onFailure: error " + t.getMessage());
            }
        });
    }

    public void login(ReqAuthorization user) {
        Call<ResAuthorization> resAuthorizationCall = mService.login(user);
        resAuthorizationCall.enqueue(new Callback<ResAuthorization>() {
            @Override
            public void onResponse(Call<ResAuthorization> call, Response<ResAuthorization> response) {

            }

            @Override
            public void onFailure(Call<ResAuthorization> call, Throwable t) {

            }
        });
    }

    public void getProductList(final OnProductResponse mProductResponse) {

        Call<List<ResProduct>> listProductsCall = mService.getProductList();
        listProductsCall.enqueue(new Callback<List<ResProduct>>() {
            @Override
            public void onResponse(Call<List<ResProduct>> call, Response<List<ResProduct>> response) {
                List<ResProduct> listProducts = response.body();
                mProductResponse.onProductRes(listProducts);
                Log.d(Constants.TAG, "onResponse: " + listProducts);
            }

            @Override
            public void onFailure(Call<List<ResProduct>> call, Throwable t) {
                Log.d(Constants.TAG, "onResponse: error");
            }
        });

    }

    public void postCommentAboutProduct(int product_id, ReqComment comment) {
        Call<ResComment> resCommentCall = mService.postCommentAboutProduct(product_id, comment);
        resCommentCall.enqueue(new Callback<ResComment>() {
            @Override
            public void onResponse(Call<ResComment> call, Response<ResComment> response) {

            }

            @Override
            public void onFailure(Call<ResComment> call, Throwable t) {

            }
        });
    }

    public void getCommentsAboutProduct(int product_id) {
        Call<List<ResProductComment>> resProductCommentCall = mService.getCommentsAboutProduct(product_id);
        resProductCommentCall.enqueue(new Callback<List<ResProductComment>>() {
            @Override
            public void onResponse(Call<List<ResProductComment>> call, Response<List<ResProductComment>> response) {
                List<ResProductComment> list = response.body();
                Log.d(Constants.TAG, "onResponse: " + list);
            }

            @Override
            public void onFailure(Call<List<ResProductComment>> call, Throwable t) {

            }
        });
    }

}
