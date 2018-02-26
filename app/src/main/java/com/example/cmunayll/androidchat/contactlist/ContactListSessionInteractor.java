package com.example.cmunayll.androidchat.contactlist;

/**
 * Created by cmunayll on 20/02/2018.
 */

public interface ContactListSessionInteractor {

    void signOff();
    String getCurrentUserEmail();
    void changeConnectionStatus(boolean online);
}
