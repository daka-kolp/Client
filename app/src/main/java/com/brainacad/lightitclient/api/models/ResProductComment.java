package com.brainacad.lightitclient.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResProductComment {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("product")
    @Expose
    private int product;
    @SerializedName("created_by")
    @Expose
    private CreatedBy createdBy;
    @SerializedName("rate")
    @Expose
    private int rate;
    @SerializedName("text")
    @Expose
    private String text;

    public ResProductComment() {
    }

    public ResProductComment(int id, int product, CreatedBy createdBy, int rate, String text) {
        super();
        this.id = id;
        this.product = product;
        this.createdBy = createdBy;
        this.rate = rate;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public CreatedBy getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(CreatedBy createdBy) {
        this.createdBy = createdBy;
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

    public class CreatedBy {

        @SerializedName("id")
        @Expose
        private int id;
        @SerializedName("username")
        @Expose
        private String username;

        public CreatedBy() {
        }


        public CreatedBy(int id, String username) {
            super();
            this.id = id;
            this.username = username;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

}