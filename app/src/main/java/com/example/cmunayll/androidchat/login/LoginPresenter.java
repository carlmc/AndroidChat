package com.example.cmunayll.androidchat.login;

import com.example.cmunayll.androidchat.login.events.LoginEvent;

/**
 * Created by cmunayll on 20/02/2018.
 */

public interface LoginPresenter {

    void onCreate();
    void onDestroy();
    void checkForAuthenticatedUser();
    void onEventMainThread(LoginEvent event);
    void validateLogin(String email, String password);
    void registerNewUser(String email, String password);

}
