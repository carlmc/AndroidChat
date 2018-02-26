package com.example.cmunayll.androidchat.chat;

import com.example.cmunayll.androidchat.chat.entities.ChatMessage;
import com.example.cmunayll.androidchat.chat.events.ChatEvent;
import com.example.cmunayll.androidchat.domain.FirebaseHelper;
import com.example.cmunayll.androidchat.lib.EventBus;
import com.example.cmunayll.androidchat.lib.GreenRobotEventBus;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

/**
 * Created by cmunayll on 21/02/2018.
 */

public class ChatRepositoryImpl implements ChatRepository {

    private String receiver;
    private FirebaseHelper helper;
    private ChildEventListener chatEventListener;

    public ChatRepositoryImpl() {
        helper = FirebaseHelper.getInstance();
    }

    @Override
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @Override
    public void subscribeForChatUpates() {
        if (chatEventListener == null) {
            chatEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    ChatMessage chatMessage = dataSnapshot.getValue(ChatMessage.class);
                    String msgSender = chatMessage.getSender();
                    msgSender = msgSender.replace("_", ".");

                    String currentUserEmail = helper.getAuthUserEmail();
                    chatMessage.setSentByMe(msgSender.equals(currentUserEmail));

                    ChatEvent chatEvent = new ChatEvent(chatMessage);
                    EventBus eventBus = GreenRobotEventBus.getInstance();
                    eventBus.post(chatEvent);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            };
            helper.getChatsReference(receiver).addChildEventListener(chatEventListener);
        }
    }

    @Override
    public void unSubscribeForChatUpates() {
        if (chatEventListener != null) {
            helper.getChatsReference(receiver).removeEventListener(chatEventListener);
        }
    }

    @Override
    public void destroyChatListener() {
        chatEventListener = null;
    }

    @Override
    public void sendMessage(String msg) {
        String keySender = helper.getAuthUserEmail().replace(".", "_");
        ChatMessage chatMessage = new ChatMessage(keySender, msg);
        DatabaseReference chatReference = helper.getChatsReference(receiver);
        chatReference.push().setValue(chatMessage);
    }

    @Override
    public void changeUserConnectionStatus(boolean online) {
        helper.changeUserConnectionStatus(online);
    }
}
