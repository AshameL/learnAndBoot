package com.example.learn.z_other.jdk_event.listener;

import com.example.learn.z_other.jdk_event.event.UserEvent;

import java.util.EventListener;

public interface UserListener<E extends UserEvent>  extends EventListener {

    void onRegister(E event);
}
