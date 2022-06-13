//package com.xiayu.springboot_jar.controller;
//
//import com.alibaba.fastjson.JSON;
//import com.xiayu.springboot_jar.bo.EasipassCustomsPushDTO;
//import com.xiayu.springboot_jar.domain.UserPlus;
//import com.xiayu.springboot_jar.mapper.UserPlusMapper;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author xuhongyu
// * @describe
// * @create 2021-09-14-5:42 下午
// */
//@RestController
//@RequestMapping("/mybatisPlusController")
//@Api("亿通测试")
//public class EasipassController {
//    @Autowired
//    private UserPlusMapper userPlusMapper;
//
//
//    @ApiOperation(value = "亿通推送-报关信息")
//    @PostMapping(value = "push")
//    public String push(@RequestBody EasipassCustomsPushDTO easipassCustomsPushDTO) {
//
//        UserPlus userPlus = new UserPlus();
//
//        userPlus.setName("亿通");
//        userPlus.setAge(0);
//        String s = JSON.toJSONString(easipassCustomsPushDTO);
//        userPlus.setEmail(s);
//
//        userPlusMapper.insert(userPlus);
//        String s1 = JSON.toJSONString(easipassCustomsPushDTO);
//        return s1;
//    }
//
//
//    public static String subStrByStrAndLen(String str, int len) {
//        return null != str ? str.substring(0, str.length() > len ? len : str.length()) : null;
//    }
//}