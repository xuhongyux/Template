package com.example.springboot_test.controller;

import com.alibaba.fastjson.JSON;
import com.example.springboot_test.bo.EasipassCustomsPushDTO;
import com.example.springboot_test.http.HttpUtil;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xuhongyu
 * @create 2021-07-02 11:09
 */
@RestController
@Api(value="/test", tags="测试接口模块")
public class TestController {

    @Autowired
    HttpUtil httpUtil;

    @ApiOperation(value = "亿通推送-报关信息")
    @GetMapping(value = "yitongHttp")
    public String yitongHttp(@RequestParam String bloNo){

        String s = httpUtil.yitongUtil(bloNo);
        return s;
    }
    @ApiOperation(value = "接收推送")
    @PostMapping(value = "push")
    public String push(@RequestBody String str){
        EasipassCustomsPushDTO user = JSON.parseObject(str, EasipassCustomsPushDTO.class);
        return user.toString();
    }
}
