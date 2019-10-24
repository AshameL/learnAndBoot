package com.example.learn.web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class HttpService {

    public String getDataByCityName(String uri) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String strbody="";
        try{
             strbody = restTemplate.exchange(uri, HttpMethod.GET, entity,String.class).getBody();
        }catch (Exception e){
            log.warn(e.getMessage());
            log.warn(uri);
        }

        return strbody;
    }
}
