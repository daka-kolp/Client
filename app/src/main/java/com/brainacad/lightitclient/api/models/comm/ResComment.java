package com.brainacad.lightitclient.api.models.comm;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResComment {

    @SerializedName("review_id")
    @Expose
    private int reviewId;

    public ResComment() {
    }

    public ResComment(int reviewId) {
        super();
        this.reviewId = reviewId;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

}