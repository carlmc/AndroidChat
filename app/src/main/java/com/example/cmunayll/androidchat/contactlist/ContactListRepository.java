package com.example.cmunayll.androidchat.contactlist;

/**
 * Created by cmunayll on 20/02/2018.
 */

public interface ContactListRepository {

    void signOff();
    String getCurrentEmail();
    void removeContact(String email);
    void destroyContactListListener();
    void subscribeForContactListUpdates();
    void unSubscribeForContactListUpdates();
    void changeUserConnectionStatus(boolean online);
}
