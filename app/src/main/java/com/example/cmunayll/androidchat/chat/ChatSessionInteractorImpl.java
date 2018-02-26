package com.example.cmunayll.androidchat.chat;

/**
 * Created by cmunayll on 21/02/2018.
 */

public class ChatSessionInteractorImpl implements ChatSessionInteractor {

    ChatRepository chatRepository;

    public ChatSessionInteractorImpl() {
        this.chatRepository = new ChatRepositoryImpl();
    }

    @Override
    public void changeConnectionStatus(boolean online) {
        chatRepository.changeUserConnectionStatus(online);
    }
}
