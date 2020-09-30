package com.xiayu.oauth.controller;

import com.xiayu.oauth.domain.UserVo;
import com.xiayu.oauth.mapper.UserMapper;
import com.xiayu.provider.api.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
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


@Api(value = "Oauth2")
@RestController
@RequestMapping(value = "user/")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Reference(version = "1.0.0")
    private UserService userService;


    @ApiOperation(value = "获取用户", httpMethod = "GET")
    @GetMapping(value = "/")
    public List<UserVo> getUser(){
        List<UserVo> user = userMapper.getUser();
        userService.getUser();
        return user;
    }
}
