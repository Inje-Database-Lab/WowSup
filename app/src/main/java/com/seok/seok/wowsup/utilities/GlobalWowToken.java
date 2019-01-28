package com.seok.seok.wowsup.utilities;

import android.util.Log;

public class GlobalWowToken {
    private static GlobalWowToken globalWowToken = new GlobalWowToken();
    private String idToken;
    private String imageURL;

    private GlobalWowToken(){
        Log.d("Start","싱글톤 시작");
    }

    public static GlobalWowToken getInstance(){
        return globalWowToken;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}