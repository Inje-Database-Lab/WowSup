package com.seok.seok.wowsup.utilities;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.seok.seok.wowsup.R;
import com.seok.seok.wowsup.retrofit.model.ResponseCommonObj;
import com.seok.seok.wowsup.retrofit.model.ResponseWriteObj;
import com.seok.seok.wowsup.retrofit.remote.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//친구신청온 것을 확인하는 다이얼로그
public class FriendConfirmDialog extends Dialog implements View.OnClickListener {
    private static int LAYOUT;
    private Context context;
    private String userID, otherUserID;
    private Button btnYes, btnNo;
    public FriendConfirmDialog(Context context) {
        super(context);
        LAYOUT = R.layout.layout_friend_confirm_dialog;
        this.context = context;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        btnYes = findViewById(R.id.dialog_friend_btn_yes);
        btnNo = findViewById(R.id.dialog_friend_btn_no);
        btnYes.setOnClickListener(this);
        btnNo.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.dialog_friend_btn_yes:
                //YES 버튼을 눌렀을 경우 친구요청 서버 통신
                ApiUtils.getCommonService().requestApplyFriend(userID, otherUserID).enqueue(new Callback<ResponseCommonObj>() {
                    @Override
                    public void onResponse(Call<ResponseCommonObj> call, Response<ResponseCommonObj> response) {
                        if (response.isSuccessful()) {
                            ResponseCommonObj body = response.body();
                            if (body.getStatus() == 1) {
                                Toast.makeText(context, "Friend request success!", Toast.LENGTH_SHORT).show();
                            } else if (body.getStatus() == 0) {
                                Toast.makeText(context, "You are already a friend request.", Toast.LENGTH_SHORT).show();
                            }else if(body.getStatus() == 2){
                                Toast.makeText(context, "It is my own writing.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        dismiss();
                    }

                    @Override
                    public void onFailure(Call<ResponseCommonObj> call, Throwable t) {
                        Toast.makeText(context, "Friend request failed", Toast.LENGTH_SHORT).show();
                        dismiss();
                    }
                });
                break;
            case R.id.dialog_friend_btn_no:
                //NO 버튼을 눌렀을 경우 다이얼로그 닫기
                dismiss();
                break;
        }
    }
    public void requestApplyFriend(String userID, String otherUserID) {
        this.userID = userID;
        this.otherUserID = otherUserID;
    }
}
