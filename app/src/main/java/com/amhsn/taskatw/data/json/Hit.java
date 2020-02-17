package com.amhsn.taskatw.data.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hit{

    @SerializedName("largeImageURL")
    @Expose
    private String largeImageURL;
    @SerializedName("likes")
    @Expose
    private int likes;
    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("userImageURL")
    @Expose
    private String userImageURL;

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public void setLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUserImageURL() {
        return userImageURL;
    }

    public void setUserImageURL(String userImageURL) {
        this.userImageURL = userImageURL;
    }

}