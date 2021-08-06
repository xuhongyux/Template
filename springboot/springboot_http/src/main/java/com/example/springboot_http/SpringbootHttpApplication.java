package com.example.springboot_http;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ComponentScan(basePackages = {"com.duckbillscm.customer","com.duckbillscm.configuration"})
@SpringBootApplication
public class SpringbootHttpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHttpApplication.class, args);
    }

}
