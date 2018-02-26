package com.example.cmunayll.androidchat.contactlist;

import com.example.cmunayll.androidchat.contactlist.events.ContactListEvent;

/**
 * Created by cmunayll on 20/02/2018.
 */

public interface ContactListPresenter {

    void onPause();
    void onResume();
    void onCreate();
    void onDestroy();

    void signOff();
    String getCurrentUserEmail();
    void removeContact(String email);
    void onEventMainThread(ContactListEvent event);
}
