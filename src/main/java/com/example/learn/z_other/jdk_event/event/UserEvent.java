package com.example.learn.z_other.jdk_event.event;

import java.util.EventObject;

public abstract class UserEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public UserEvent(Object source) {
        super(source);
    }
}
