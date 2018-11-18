package com.brainacad.lightitclient.api.models.regist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResRegistration {

    @SerializedName("success")
    @Expose
    private boolean success;
    @SerializedName("token")
    @Expose
    private String token;

    public ResRegistration() {
    }

    public ResRegistration(boolean success, String token) {
        super();
        this.success = success;
        this.token = token;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}