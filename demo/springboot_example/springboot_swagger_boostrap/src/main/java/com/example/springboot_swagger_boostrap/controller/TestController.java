package com.example.springboot_swagger_boostrap.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhongyu
 * @create 2021-06-05 9:40
 */
@RestController
@Api(value="/test1", tags="测试接口模块")
public class TestController {

    @ApiOperation("test")
    @GetMapping("/ha")
    public String test(){
        return "test成功";
    }
    @ApiOperation("Area删除")
    @GetMapping("/a")
    public String ha(){
        return "Area删除成功";
    }

}
