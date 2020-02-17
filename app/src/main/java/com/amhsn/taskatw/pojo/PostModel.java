package com.amhsn.taskatw.pojo;

public class PostModel {

    private String postImgURL, userName, userImgURL;
    private int likes;

    public PostModel() {
    }

    public PostModel(String user, int likes, String largeImageURL, String userImageURL) {
        this.userName = user;
        this.likes = likes;
        this.postImgURL = largeImageURL;
        this.userImgURL =userImageURL;
    }

    public String getPostImgURL() {
        return postImgURL;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserImgURL() {
        return userImgURL;
    }

    public int getLikes() {
        return likes;
    }

    public void setPostImgURL(String postImgURL) {
        this.postImgURL = postImgURL;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserImgURL(String userImgURL) {
        this.userImgURL = userImgURL;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
