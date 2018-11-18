package com.brainacad.lightitclient.api.models.comm;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReqComment {

    @SerializedName("rate")
    @Expose
    private int rate;
    @SerializedName("text")
    @Expose
    private String text;


    public ReqComment() {
    }

    public ReqComment(int rate, String text) {
        super();
        this.rate = rate;
        this.text = text;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}