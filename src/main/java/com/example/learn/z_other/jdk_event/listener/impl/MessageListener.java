package com.example.learn.z_other.jdk_event.listener.impl;

import com.example.learn.z_other.jdk_event.event.MessageEvent;
import com.example.learn.z_other.jdk_event.event.UserEvent;
import com.example.learn.z_other.jdk_event.model.User;
import com.example.learn.z_other.jdk_event.listener.UserListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageListener implements UserListener {

    @Override
    public void onRegister(UserEvent event) {
        if (event instanceof MessageEvent) {

            Object source = event.getSource();
            User user = (User) source;
            log.info("send message to {}" , user.getPhoneNumber());
        }
    }
}
