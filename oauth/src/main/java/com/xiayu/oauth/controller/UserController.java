package com.xiayu.oauth.controller;

import com.xiayu.oauth.domain.UserVo;
import com.xiayu.oauth.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/9/26 19:46
 */
@RestController
@RequestMapping(value = "user/")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "/")
    public List<UserVo> getUser(){
        List<UserVo> user = userMapper.getUser();
        return user;
    }
}
