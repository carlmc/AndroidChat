package com.example.cmunayll.androidchat.chat;

/**
 * Created by cmunayll on 21/02/2018.
 */

public class ChatInteractorImpl implements ChatInteractor {



    ChatRepository chatRepository;

    public ChatInteractorImpl() {
        this.chatRepository = new ChatRepositoryImpl();
    }

    @Override
    public void sendMessage(String msg) {
        chatRepository.sendMessage(msg);
    }

    @Override
    public void setRecipient(String recipient) {
        chatRepository.setReceiver(recipient);
    }

    @Override
    public void destroyChatListener() {
        chatRepository.destroyChatListener();
    }

    @Override
    public void subscribeForChatUpates() {
        chatRepository.subscribeForChatUpates();
    }

    @Override
    public void unsubscribeForChatUpates() {
        chatRepository.unSubscribeForChatUpates();
    }
}
