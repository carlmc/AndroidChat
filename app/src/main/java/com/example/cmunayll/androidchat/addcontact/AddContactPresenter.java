package com.example.cmunayll.androidchat.addcontact;

import com.example.cmunayll.androidchat.addcontact.events.AddContactEvent;

/**
 * Created by cmunayll on 21/02/2018.
 */

public interface AddContactPresenter {

    void onShow();
    void onDestroy();

    void addContact(String email);
    void onEventMainThread(AddContactEvent event);
}
