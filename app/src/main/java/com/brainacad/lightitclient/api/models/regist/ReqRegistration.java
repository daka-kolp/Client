package com.brainacad.lightitclient.api.models.regist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReqRegistration {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;

    public ReqRegistration() {
    }

    public ReqRegistration(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}