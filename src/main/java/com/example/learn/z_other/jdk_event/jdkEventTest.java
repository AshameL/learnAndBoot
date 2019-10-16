package com.example.learn.z_other.jdk_event;

import com.example.learn.z_other.jdk_event.listener.impl.MessageListener;
import com.example.learn.z_other.jdk_event.model.User;
import com.example.learn.z_other.jdk_event.service.UserService;

public class jdkEventTest {
    public static void main(String[] args) {
        UserService userService = new UserService();

        // 添加发送短信的监听器
        userService.addListeners(new MessageListener());
        // 还可以添加其他的监听器。。。

        User user = new User("zhangsan", "123456", "15174480311");
        userService.register(user);
    }
}
