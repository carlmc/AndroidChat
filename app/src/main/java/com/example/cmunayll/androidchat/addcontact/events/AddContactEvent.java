package com.example.cmunayll.androidchat.addcontact.events;

/**
 * Created by cmunayll on 21/02/2018.
 */

public class AddContactEvent {

    boolean error = false;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
