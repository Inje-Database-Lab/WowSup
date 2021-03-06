package com.seok.seok.wowsup.fragments.fragchat;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.seok.seok.wowsup.R;

public class ChatViewHolder extends RecyclerView.ViewHolder {
    //채팅 바인딩 뷰 홀더 클래스 리사이클러 뷰에 뿌리기위함
    public ImageView chatFriendImage, chatFriendCountry;
    public TextView chatFriend, chatFriendSelfish;
    public Button chatFriendOption;
    public ChatViewHolder(View itemView) {
        super(itemView);
        this.chatFriendImage = itemView.findViewById(R.id.fragment_chat_firend_image);
        this.chatFriend = itemView.findViewById(R.id.fragment_chat_firend);
        this.chatFriendOption = itemView.findViewById(R.id.fragment_chat_firend_option);
        this.chatFriendSelfish = itemView.findViewById(R.id.fragment_chat_friend_selfish);
    }
}