package com.example.cmunayll.androidchat.login;

/**
 * Created by cmunayll on 20/02/2018.
 */

public interface LoginInteractor {

    void checkAlreadyAuthenticated();
    void doSignUp(String email, String password);
    void doSignIn(String email, String password);
}
