package com.example.cmunayll.androidchat.lib;

/**
 * Created by cmunayll on 20/02/2018.
 */

public interface EventBus {

    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
