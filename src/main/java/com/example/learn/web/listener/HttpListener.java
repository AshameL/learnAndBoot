package com.example.learn.web.listener;

import com.example.learn.web.service.HttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HttpListener {
    @Autowired
    private  HttpService httpService;

    @Scheduled(fixedRate = 1000)
    public void reportCurrentTime() {
        httpService.getDataByCityName("https://beihai.focus.cn/zixun/49bb631b0713013a.html");
        httpService.getDataByCityName("https://beihai.focus.cn/zixun/94426b51cf4de860.html");
        httpService.getDataByCityName("https://beihai.focus.cn/zixun/e8ebc8ead79816f3.html");
        httpService.getDataByCityName("https://beihai.focus.cn/zixun/9092281cf5e053bd.html");
        httpService.getDataByCityName("https://beihai.focus.cn/zixun/d3e4068637c6e9a4.html");
        httpService.getDataByCityName("https://beihai.focus.cn/zixun/232cc2772cfe7a26.html");
        httpService.getDataByCityName("https://beihai.focus.cn/zixun/0c5c345724a08ce7.html");
    }
}
