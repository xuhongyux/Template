package com.xiayu.springboot_jar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-08-12-9:04 上午
 */
@MapperScan("com.xiayu.springboot_jar.mapper")
@SpringBootApplication
public class SpringBootJarApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootJarApplication.class,args);
    }
}