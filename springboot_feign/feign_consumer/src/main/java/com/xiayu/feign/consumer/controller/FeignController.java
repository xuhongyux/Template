package com.xiayu.feign.consumer.controller;

import com.xiayu.feign.consumer.feign.ProviderTemp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-09-02-11:12 上午
 */
@Slf4j
@RestController
@Api(value="/feign", tags="feign")
public class FeignController {
    @Autowired
    private ProviderTemp providerTemp;

    @ApiOperation(value = "hello", notes = "欢迎接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, paramType = "query", dataType = "String", example = "XiaYu")})
    @GetMapping("/hello")
    public String hello(@RequestParam String userName) throws Exception {
        try {
            String hello = providerTemp.hello(userName);
            return hello;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @ApiOperation(value = "post", notes = "post")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, paramType = "query", dataType = "String", example = "XiaYu")})
    @PostMapping("/post")
    public String post(String userName) throws Exception {
        try {
            String hello = providerTemp.post(userName);
            return hello;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}