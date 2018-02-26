package com.example.cmunayll.androidchat.chat;

import com.example.cmunayll.androidchat.chat.entities.ChatMessage;
import com.example.cmunayll.androidchat.chat.events.ChatEvent;
import com.example.cmunayll.androidchat.chat.ui.ChatView;
import com.example.cmunayll.androidchat.contactlist.entities.User;
import com.example.cmunayll.androidchat.lib.EventBus;
import com.example.cmunayll.androidchat.lib.GreenRobotEventBus;

/**
 * Created by cmunayll on 21/02/2018.
 */

public class ChatPresenterImpl implements ChatPresenter {

    EventBus eventBus;
    ChatView chatView;
    ChatInteractor chatInteractor;
    ChatSessionInteractor chatSessionInteractor;

    public ChatPresenterImpl(ChatView chatView) {
        this.chatView = chatView;
        this.eventBus = GreenRobotEventBus.getInstance();
        this.chatInteractor = new ChatInteractorImpl();
        this. chatSessionInteractor = new ChatSessionInteractorImpl();
    }

    @Override
    public void onPause() {
        chatInteractor.unsubscribeForChatUpates();
        chatSessionInteractor.changeConnectionStatus(User.OFFLINE);
    }

    @Override
    public void onResume() {
        chatInteractor.subscribeForChatUpates();
        chatSessionInteractor.changeConnectionStatus(User.ONLINE);
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);
        chatInteractor.destroyChatListener();
        chatView = null;
    }

    @Override
    public void setChatRecipient(String recipient) {
        this.chatInteractor.setRecipient(recipient);
    }

    @Override
    public void sendMessage(String msg) {
        chatInteractor.sendMessage(msg);
    }

    @Override
    public void onEventMainThread(ChatEvent event) {
        if (chatView != null) {
            ChatMessage msg = event.getMessage();
            chatView.onMessageReceived(msg);
        }
    }
}
