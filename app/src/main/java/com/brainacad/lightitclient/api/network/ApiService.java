package com.brainacad.lightitclient.api.network;

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
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    @POST("/api/register")
    Call<ResRegistration> registration(@Body ReqRegistration user);

    @Headers("Authorization: 'Token {token}'")
    @POST("/api/login")
    Call<ResAuthorization> login(@Body ReqAuthorization user);

    @GET("/api/products")
    Call<List<ResProduct>> getProductList();

    @Headers("Authorization: 'Token {token}'")
    @POST("/api/reviews/{product_id}")
    Call<ResComment> postCommentAboutProduct(@Path("product_id") int product_id, @Body ReqComment comment);

    @Headers("Authorization: 'Token {token}'")
    @GET("/api/reviews/{product_id}")
    Call<List<ResProductComment>> getCommentsAboutProduct(@Path("product_id") int product_id);
/*
*
{
"username": "dia123",
"password": "qwerty"
}
{
    "success": true,
    "token": "4f5d6fb90fc4ff11c35961e42bb1c03080999978"
}
* */

}

