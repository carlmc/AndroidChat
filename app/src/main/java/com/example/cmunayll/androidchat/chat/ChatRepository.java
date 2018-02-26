package com.example.cmunayll.androidchat.chat;

/**
 * Created by cmunayll on 21/02/2018.
 */

public interface ChatRepository {

    void sendMessage(String msg);
    void setReceiver(String receiver);

    void destroyChatListener();
    void subscribeForChatUpates();
    void unSubscribeForChatUpates();

    void changeUserConnectionStatus(boolean online);
}
