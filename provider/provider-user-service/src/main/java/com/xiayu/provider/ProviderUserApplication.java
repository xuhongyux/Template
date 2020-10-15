package com.xiayu.provider;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Description:
 * user 服务提供者
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/9/29 14:58
 */


@MapperScan(value = "com.xiayu.provider.mapper")
@SpringBootApplication(scanBasePackageClasses = {ProviderUserApplication.class})
public class ProviderUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderUserApplication.class, args);
    }

}
