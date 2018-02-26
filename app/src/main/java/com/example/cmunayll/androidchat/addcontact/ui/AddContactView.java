package com.example.cmunayll.androidchat.addcontact.ui;

/**
 * Created by cmunayll on 21/02/2018.
 */

public interface AddContactView {

    void showInput();
    void hideInput();
    void showProgress();
    void hideProgress();

    void contactAdded();
    void contactNotAdded();
}
