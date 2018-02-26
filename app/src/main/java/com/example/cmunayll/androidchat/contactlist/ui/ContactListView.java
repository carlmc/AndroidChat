package com.example.cmunayll.androidchat.contactlist.ui;

import com.example.cmunayll.androidchat.contactlist.entities.User;

/**
 * Created by cmunayll on 20/02/2018.
 */

public interface ContactListView {

    void onContactAdded(User user);
    void onContactChanged(User user);
    void onContactRemoved(User user);
}
