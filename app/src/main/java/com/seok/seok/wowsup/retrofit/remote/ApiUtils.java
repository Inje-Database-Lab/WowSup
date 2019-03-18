package com.seok.seok.wowsup.retrofit.remote;

public class ApiUtils {
    //Server /var/www/html 의 주소
    public static final String BASE_URL = "http://www.heywowsup.com/wowsup/";
    public static final String BASE_MAIL_URL = "http://www.heywowsup.com/awsSES/";
    public static LoginService getUserService(){
        return RetrofitClient.getClient(BASE_URL).create(LoginService.class);
    }
    public static ProfileService getProfileService(){
        return RetrofitClient.getClient(BASE_URL).create(ProfileService.class);
    }
    public static ChatService getChatService(){
        return RetrofitClient.getClient(BASE_URL).create(ChatService.class);
    }
    public static WriteService getWriteService(){
        return  RetrofitClient.getClient(BASE_URL).create(WriteService.class);
    }
    public static StoryService getStoryService() {
        return RetrofitClient.getClient(BASE_URL).create(StoryService.class);
    }
    public static CommonService getCommonService(){
        return RetrofitClient.getClient(BASE_URL).create(CommonService.class);
    }
    public static ImageService getImageService(){
        return RetrofitClient.getClient(BASE_URL).create(ImageService.class);
    }
    public static ChatWordChart getWordService(){
        return RetrofitClient.getClient(BASE_URL).create(ChatWordChart.class);
    }
    public static MailService getEmailService(){
        return RetrofitClient.getClient(BASE_MAIL_URL).create(MailService.class);
    }
}
