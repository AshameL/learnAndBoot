package com.example.learn.z_other.jdk_event.event;

public class MessageEvent extends UserEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public MessageEvent(Object source) {
        super(source);
    }
}
