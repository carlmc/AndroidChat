package com.example.cmunayll.androidchat.login;

/**
 * Created by cmunayll on 20/02/2018.
 */

public interface LoginRepository {

    void signUp(final String email, final String password);
    void signIn(String email, String password);
    void checkAlreadyAuthenticated();
}
