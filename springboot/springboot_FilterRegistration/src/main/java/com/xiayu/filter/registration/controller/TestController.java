package com.xiayu.filter.registration.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-01-22-14:35
 */
@Api(tags = "测试类")
@RestController
@RequestMapping(value = "xiayu/")
public class TestController {

    @ApiOperation(value = "获取用户")
    @GetMapping(value = "getUser/{username}")
    public String getUser(@PathVariable String username){
        return "你好"+ username+"!";
    }

    @ApiOperation(value = "测试")
    @GetMapping(value = "")
    public String test(@RequestParam(value = "userName") String userName){
        return "你好"+ userName+"!__________________________________________";
    }

    @ApiOperation(value = "Post测试")
    @PostMapping(value = "postTest")
    public String postTest(@RequestBody String user) {
        return "你好" + user + "!__________________________________________";
    }


    @ApiOperation(value = "get请求参数放在请求体中")
    @GetMapping(value = "getRequestBodyTest")
    public  String getRequestBodyTest(@RequestBody String user){
        return "你好啊"+ user;
    }
}
