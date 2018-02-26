package com.example.cmunayll.androidchat.contactlist;

/**
 * Created by cmunayll on 20/02/2018.
 */

public interface ContactListInteractor {

    void subscribeForContactEvents();
    void unsubscribeForContactEvents();
    void destroyContactListListener();
    void removeContact(String email);
}
