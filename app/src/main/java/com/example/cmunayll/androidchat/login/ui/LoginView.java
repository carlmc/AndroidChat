package com.example.cmunayll.androidchat.login.ui;

/**
 * Created by cmunayll on 20/02/2018.
 */

public interface LoginView {

    void enableInputs();
    void disableInputs();
    void showProgress();
    void hideProgress();

    void handleSignUp();
    void handleSignIn();

    void navigateToMainScreen();
    void loginError(String error);

    void newUserSuccess();
    void newUserError(String error);
}
