package com.example.cmunayll.androidchat.addcontact;

/**
 * Created by cmunayll on 21/02/2018.
 */

public class AddContactInteractorImpl implements AddContactInteractor {
    AddContactRepositoryImpl addContactRepository;

    public AddContactInteractorImpl(AddContactRepositoryImpl addContactRepository) {
        this.addContactRepository = addContactRepository;
    }

    @Override
    public void addContact(String email) {
        addContactRepository.addContact(email);
    }
}
