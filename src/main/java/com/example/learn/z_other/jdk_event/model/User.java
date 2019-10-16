package com.example.learn.z_other.jdk_event.model;

import lombok.Data;

@Data
public class User {
    private String username;
    private String password;
    private String phoneNumber;

    public User(String username, String password, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
