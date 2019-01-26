package com.seok.seok.wowsup.retrofit.remote;

public class ApiUtils {
    //Server /var/www/html 의 주소
    public static final String BASE_URL = "http://203.241.228.121/";
    public static LoginService getUserService(){
        return RetrofitClient.getClient(BASE_URL).create(LoginService.class);
    }
    public static ProfileService getProfileService(){
        return RetrofitClient.getClient(BASE_URL).create(ProfileService.class);
    }
}
