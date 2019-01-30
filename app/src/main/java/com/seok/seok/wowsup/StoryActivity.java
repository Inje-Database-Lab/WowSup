package com.seok.seok.wowsup;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.seok.seok.wowsup.retrofit.model.ResponseStoryObj;
import com.seok.seok.wowsup.retrofit.remote.ApiUtils;
import com.seok.seok.wowsup.utilities.Common;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoryActivity extends AppCompatActivity {
    private String storyID;
    private TextView storyTextBody, storyTextTag1, storyTextTag2, storyTextTag3, storyTextTag4, storyTextTag5, storyTextcntlike;
    private LinearLayout storyLayoutBackground;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        storyLayoutBackground = findViewById(R.id.story_laytout_background);
        storyTextBody = findViewById(R.id.story_text_body);
        storyTextTag1 = findViewById(R.id.story_text_tag1);
        storyTextTag2 = findViewById(R.id.story_text_tag2);
        storyTextTag3 = findViewById(R.id.story_text_tag3);
        storyTextTag4 = findViewById(R.id.story_text_tag4);
        storyTextTag5 = findViewById(R.id.story_text_tag5);
        storyTextcntlike = findViewById(R.id.story_text_cntlike);


        Intent intent  = getIntent();
        storyID = intent.getStringExtra("storyID");
        Log.d("gggg", storyID);

        ApiUtils.getStoryService().requestOneStoryView(storyID).enqueue(new Callback<ResponseStoryObj>() {
            @Override
            public void onResponse(Call<ResponseStoryObj> call, Response<ResponseStoryObj> response) {
                Log.d("Storrr", storyID);
                ResponseStoryObj body = response.body();
                if(response.isSuccessful()){
                    try{
                        Log.d("Storrr","1");
                        storyTextBody.setText(body.getBody());
                        Log.d("Storrr","2");
                        storyTextTag1.setText(body.getTag1());
                        Log.d("Storrr", body.getImageURL());
                        storyTextTag2.setText(body.getTag2());
                        Log.d("Storrr", body.getImageURL());
                        storyTextTag3.setText(body.getTag3());
                        Log.d("Storrr", body.getImageURL());
                        storyTextTag4.setText(body.getTag4());
                        Log.d("Storrr", body.getImageURL());
                        storyTextTag5.setText(body.getTag5());
                        Log.d("Storrr", body.getImageURL());
                        storyTextcntlike.setText(body.getCntLike()+"");
                        Log.d("Storrr", body.getImageURL());
                        if(!body.getImageURL().equals(null)){
                            Glide.with(getApplicationContext()).load(Common.API_IMAGE_BASE_URL+body.getImageURL()).into(new SimpleTarget<GlideDrawable>() {
                                @Override
                                public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                                    storyLayoutBackground.setBackground(resource);
                                }
                            });
                        }
                    }catch(Exception e){
                        Glide.with(getApplicationContext()).load(Common.STORY_IMAGE_BASE_URL).into(new SimpleTarget<GlideDrawable>() {
                            @Override
                            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                                storyLayoutBackground.setBackground(resource);
                            }
                        });
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseStoryObj> call, Throwable t) {
                Log.d("Storrr", t.getMessage());
            }
        });
    }
}
