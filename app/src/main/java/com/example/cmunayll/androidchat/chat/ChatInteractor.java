package com.example.cmunayll.androidchat.chat;

/**
 * Created by cmunayll on 21/02/2018.
 */

public interface ChatInteractor {

    void sendMessage(String msg);
    void setRecipient(String recipient);

    void destroyChatListener();
    void subscribeForChatUpates();
    void unsubscribeForChatUpates();
}
