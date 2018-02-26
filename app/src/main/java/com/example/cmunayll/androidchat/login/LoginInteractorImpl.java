package com.example.cmunayll.androidchat.login;

/**
 * Created by cmunayll on 20/02/2018.
 */

public class LoginInteractorImpl implements LoginInteractor {

    private LoginRepository loginRepository;

    public LoginInteractorImpl() {
        this.loginRepository = new LoginRepositoryImpl();
    }

    @Override
    public void checkAlreadyAuthenticated() {
        loginRepository.checkAlreadyAuthenticated();
    }

    @Override
    public void doSignUp(final String email, final String password) {
        loginRepository.signUp(email, password);
    }

    @Override
    public void doSignIn(String email, String password) {
        loginRepository.signIn(email, password);
    }
}
