package com.seok.seok.wowsup.utilities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.seok.seok.wowsup.R;
//채팅 다이얼로그 클래스
public class ChatOptionDialog{

    private Context context;
    private Button btnSetfriendName, btnDeleteChat;
    private Dialog dlg;
    private SetFriendNickDialog setFriendNickDialog;
    public ChatOptionDialog(Context context)
    {
        this.context = context;
        setFriendNickDialog = new SetFriendNickDialog(context);
    }

    public void chatOptionFunction()
    {
        dlg = new Dialog(context);
        dlg.setContentView(R.layout.layout_chatoption_dialog);

        dlg.show();

        //이름변경 버튼 클릭
        btnSetfriendName = (Button)dlg.findViewById(R.id.dialog_setfriend_btn);
        btnSetfriendName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFriendNickDialog.NickFunction();
            }
        });

        //친구 삭제 버튼 클릭
        btnDeleteChat = (Button) dlg.findViewById(R.id.dialog_chat_delete_btn);
        btnDeleteChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                alert.setTitle("Delete");
                alert.setMessage("Are you sure you want to delete it?");

                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("aaa","ffffffff");
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                            endChatOption();
                    }
                });
                alert.show();
            }
        });
    }
    public void endChatOption()
    {
        dlg.dismiss();
    }


}