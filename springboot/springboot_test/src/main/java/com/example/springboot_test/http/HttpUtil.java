package com.example.springboot_test.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-09-26-10:45 上午
 */
@Service
public class HttpUtil {

    @Autowired
    RestTemplate restTemplate;

    public String yitongUtil(String bloNo ){
        String url = "http://localhost:8080/customs/subscribe?blNo=";

        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(url);
        urlBuilder.append(bloNo);

        ResponseEntity<String> forEntity = restTemplate.getForEntity(urlBuilder.toString(), String.class);

        String body = forEntity.getBody();
        System.out.println(body);
        return body;

    }
}