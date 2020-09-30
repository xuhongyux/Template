package com.xiayu.oauth;

import com.xiayu.configuration.Swagger2Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication(scanBasePackageClasses = {OauthApplication.class,Swagger2Configuration.class})
@MapperScan(value = "com.xiayu.oauth.mapper")
public class OauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthApplication.class, args);
    }

}
