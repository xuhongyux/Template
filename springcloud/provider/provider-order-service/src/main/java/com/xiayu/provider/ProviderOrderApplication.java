package com.xiayu.provider;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Description:
 * Order 服务提供者
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/9/29 14:58
 */

@EnableTransactionManagement
@MapperScan(value = "com.xiayu.provider.mapper")
@SpringBootApplication(scanBasePackageClasses = {ProviderOrderApplication.class},exclude={DataSourceAutoConfiguration.class})
public class ProviderOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderOrderApplication.class, args);
    }

}
