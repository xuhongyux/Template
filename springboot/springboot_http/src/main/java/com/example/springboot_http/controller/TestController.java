package com.example.springboot_http.controller;

import com.example.springboot_http.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhongyu
 * @create 2021-07-02 11:09
 */
@RestController
@Api(value="/test1", tags="测试接口模块")
public class TestController {

    @ApiOperation(value = "GET", notes = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, paramType = "query", dataType = "String", example = "XiaYu")})
    @GetMapping("/helloGET")
    public Object helloGet(@RequestParam String userName){
        return  userName;
    }


    @ApiOperation(value = "Post", notes = "Post")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, paramType = "query", dataType = "String", example = "XiaYu")})
    @PostMapping("/helloPost")
    public Object hello(@RequestParam String userName, @RequestBody UserDto userDto){

        return  userName+userDto.toString();
    }








}
