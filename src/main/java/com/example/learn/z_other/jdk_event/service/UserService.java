package com.example.learn.z_other.jdk_event.service;

import com.example.learn.z_other.jdk_event.event.MessageEvent;
import com.example.learn.z_other.jdk_event.event.UserEvent;
import com.example.learn.z_other.jdk_event.listener.UserListener;
import com.example.learn.z_other.jdk_event.model.User;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 注册监听器、当用户注册的时候，触发事件；
 * 也就是我们所说的事件环境，相当于spring中的AbstractApplicationContext
 */
@Slf4j
public class UserService {

    private List<UserListener> listeneres = new ArrayList<>();

    /**
     * 当用户注册的时候，触发发送短信事件
     * 相当于事件源
     * @param user
     */
    public void register(User user){

        log.info("插入用户信息：" + user + " 到数据库");
        UserEvent event = new MessageEvent(user);
        this.publishEvent(event);

    }

    public void publishEvent(UserEvent event){

        for(UserListener listener : listeneres){
            listener.onRegister(event);
        }

    }

    public void addListeners(UserListener listener){
        this.listeneres.add(listener);
    }
}