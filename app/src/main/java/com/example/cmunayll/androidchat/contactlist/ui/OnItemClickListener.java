package com.example.cmunayll.androidchat.contactlist.ui;

import com.example.cmunayll.androidchat.contactlist.entities.User;

/**
 * Created by cmunayll on 20/02/2018.
 */

public interface OnItemClickListener {

    void onItemClick(User user);
    void onItemLongClick(User user);
}
