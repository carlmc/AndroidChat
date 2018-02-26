package com.example.cmunayll.androidchat;

import android.app.Application;

import com.example.cmunayll.androidchat.lib.GlideImageLoader;
import com.example.cmunayll.androidchat.lib.ImageLoader;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by cmunayll on 20/02/2018.
 */

public class AndroidChatApplication extends Application {

    private ImageLoader imageLoader;

    @Override
    public void onCreate() {
        super.onCreate();
        setupFirebase();
        setupImageLoader();
    }

    private void setupImageLoader() {
        imageLoader = new GlideImageLoader(this);
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    private void setupFirebase(){
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
