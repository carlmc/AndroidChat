package com.example.cmunayll.androidchat.chat;

import com.example.cmunayll.androidchat.chat.events.ChatEvent;

/**
 * Created by cmunayll on 20/02/2018.
 */

public interface ChatPresenter {

    void onPause();
    void onResume();
    void onCreate();
    void onDestroy();

    void setChatRecipient(String recipient);

    void sendMessage(String msg);
    void onEventMainThread(ChatEvent event);
}
