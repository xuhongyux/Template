package com.xiayu.oauth2Service;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/10/13 19:57
 */

@SpringBootApplication(scanBasePackageClasses = {Oauth2ServiceApplication.class})
public class Oauth2ServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(Oauth2ServiceApplication.class, args);
    }

}
