package com.example.cmunayll.androidchat.lib;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

/**
 * Created by cmunayll on 20/02/2018.
 */

public class GlideImageLoader implements ImageLoader {

    private RequestManager glideRequestManager;

    public GlideImageLoader(Context context) {
        this.glideRequestManager = Glide.with(context);
    }

    @Override
    public void load(ImageView imageView, String URL) {
        glideRequestManager.load(URL).into(imageView);
    }
}
