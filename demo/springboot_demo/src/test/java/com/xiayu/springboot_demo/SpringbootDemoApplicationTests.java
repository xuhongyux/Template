package com.xiayu.springboot_demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@SpringBootTest
class SpringbootDemoApplicationTests {

    @Test
    void contextLoads() {


    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String decode = URLDecoder.decode("%E5%BE%90%E5%BE%90", "UTF-8");
        System.out.println(decode);
    }

}
