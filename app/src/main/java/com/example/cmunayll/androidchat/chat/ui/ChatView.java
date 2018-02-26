package com.example.cmunayll.androidchat.chat.ui;

import com.example.cmunayll.androidchat.chat.entities.ChatMessage;

/**
 * Created by cmunayll on 20/02/2018.
 */

public interface ChatView {

    void sendMessage();
    void onMessageReceived(ChatMessage msg);
}
