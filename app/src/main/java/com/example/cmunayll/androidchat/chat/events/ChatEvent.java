package com.example.cmunayll.androidchat.chat.events;

import com.example.cmunayll.androidchat.chat.entities.ChatMessage;

/**
 * Created by cmunayll on 21/02/2018.
 */

public class ChatEvent {

    ChatMessage msg;

    public ChatEvent(ChatMessage msg) {
        this.msg = msg;
    }

    public ChatMessage getMessage() {
        return msg;
    }
}
