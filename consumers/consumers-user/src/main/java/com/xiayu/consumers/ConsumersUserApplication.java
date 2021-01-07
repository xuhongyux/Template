package com.xiayu.consumers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Description:
 *  用户 服务消费者服务
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/10/3 11:27
 */
//开始feign客户端监听
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackageClasses ={ConsumersUserApplication.class})
public class ConsumersUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumersUserApplication.class, args);
    }
}
