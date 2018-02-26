package com.example.cmunayll.androidchat.contactlist.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.cmunayll.androidchat.AndroidChatApplication;
import com.example.cmunayll.androidchat.R;
import com.example.cmunayll.androidchat.addcontact.ui.AddContactFragment;
import com.example.cmunayll.androidchat.chat.ui.ChatActivity;
import com.example.cmunayll.androidchat.contactlist.ContactListPresenter;
import com.example.cmunayll.androidchat.contactlist.ContactListPresenterImpl;
import com.example.cmunayll.androidchat.contactlist.adapters.ContactListAdapter;
import com.example.cmunayll.androidchat.contactlist.entities.User;
import com.example.cmunayll.androidchat.lib.ImageLoader;
import com.example.cmunayll.androidchat.login.ui.LoginActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by cmunayll on 20/02/2018.
 */

public class ContactListActivity extends AppCompatActivity implements ContactListView, OnItemClickListener {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;

    private ContactListAdapter adapter;
    private ContactListPresenter contactListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        ButterKnife.bind(this);

        contactListPresenter = new ContactListPresenterImpl(this);
        contactListPresenter.onCreate();

        toolbar.setSubtitle(contactListPresenter.getCurrentUserEmail());
        setSupportActionBar(toolbar);

        setupAdapter();
        setupRecyclerView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        contactListPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        contactListPresenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        contactListPresenter.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_contactlist, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_logout) {
            contactListPresenter.signOff();
            Intent intent = new Intent(this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                    | Intent.FLAG_ACTIVITY_NEW_TASK
                    | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab)
    public void addContact() {
        AddContactFragment fab = new AddContactFragment();
        fab.show(getSupportFragmentManager(), "");
    }

    private void setupAdapter() {
        AndroidChatApplication app = (AndroidChatApplication) getApplication();
        ImageLoader imageLoader = app.getImageLoader();
        adapter = new ContactListAdapter(new ArrayList<User>(), imageLoader, this);
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onContactAdded(User user) {
        adapter.add(user);
    }

    @Override
    public void onContactChanged(User user) {
        adapter.update(user);
    }

    @Override
    public void onContactRemoved(User user) {
        adapter.remove(user);
    }

    @Override
    public void onItemClick(User user) {
        Intent i = new Intent(this, ChatActivity.class);
        i.putExtra(ChatActivity.EMAIL_KEY, user.getEmail());
        i.putExtra(ChatActivity.ONLINE_KEY, user.isOnline());
        startActivity(i);
    }

    @Override
    public void onItemLongClick(User user) {
        contactListPresenter.removeContact(user.getEmail());
    }
}
