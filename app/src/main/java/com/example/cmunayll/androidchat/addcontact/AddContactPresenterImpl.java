package com.example.cmunayll.androidchat.addcontact;

import com.example.cmunayll.androidchat.addcontact.events.AddContactEvent;
import com.example.cmunayll.androidchat.addcontact.ui.AddContactView;
import com.example.cmunayll.androidchat.lib.EventBus;
import com.example.cmunayll.androidchat.lib.GreenRobotEventBus;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by cmunayll on 21/02/2018.
 */

public class AddContactPresenterImpl implements AddContactPresenter {

    EventBus eventBus;
    AddContactView addContactView;
    AddContactInteractor addContactInteractor;

    public AddContactPresenterImpl(AddContactView addContactView) {
        this.eventBus = GreenRobotEventBus.getInstance();
        this.addContactView = addContactView;
        this.addContactInteractor = new AddContactInteractorImpl(new AddContactRepositoryImpl());
    }

    @Override
    public void onShow() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        addContactView = null;
        eventBus.unregister(this);
    }

    @Override
    public void addContact(String email) {
        addContactView.hideInput();
        addContactView.showProgress();
        this.addContactInteractor.addContact(email);
    }

    @Override
    @Subscribe
    public void onEventMainThread(AddContactEvent event) {
        if (addContactView != null) {
            addContactView.hideProgress();
            addContactView.showInput();

            if (event.isError()) {
                addContactView.contactNotAdded();
            } else {
                addContactView.contactAdded();
            }
        }
    }
}
