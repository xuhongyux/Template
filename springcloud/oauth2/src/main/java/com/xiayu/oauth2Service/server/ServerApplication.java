package com.xiayu.oauth2Service.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 认证服务器，用于获取Token
 */
@MapperScan( basePackages = "com.xiayu.oauth2Service.server.mapper")
@SpringBootApplication
public class ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
    //http://localhost:8080/oauth/authorize?client_id=client&response_type=code
}
