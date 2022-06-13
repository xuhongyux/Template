package com.xiayu.springboot_jar.controller;


import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhongyu
 * @create 2022-03-19 7:12 下午
 */

@RestController
@RequestMapping(value = "springboot")
public class HelloController {


    /**
     * 注册
     */
    @GetMapping(value = "/hello")
    public String reg(@RequestParam String user) {
        return "win"+"你好" + user;
    }
}
