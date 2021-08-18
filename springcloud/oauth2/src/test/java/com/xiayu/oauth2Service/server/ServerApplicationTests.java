package com.xiayu.oauth2Service.server;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@RunWith(SpringRunner.class)
////@SpringBootTest
public class ServerApplicationTests {

    @Test
    public void contextLoads() {
    }

    public static void main(String[] args) {
        System.out.println( new BCryptPasswordEncoder().encode("123456"));
    }

}
