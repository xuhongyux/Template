package com.xiayu.oauth2Service;

import com.xiayu.configuration.Swagger2Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/10/13 19:57
 */
@SpringBootApplication(scanBasePackageClasses = {Oauth2ServiceApplication.class, Swagger2Configuration.class})
public class Oauth2ServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(Oauth2ServiceApplication.class, args);
    }

}
