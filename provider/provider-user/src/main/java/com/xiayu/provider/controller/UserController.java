package com.xiayu.provider.controller;

import com.xiayu.provider.api.UserService;
import com.xiayu.provider.domain.TestUser;
import com.xiayu.provider.mapper.TestUserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/9/29 15:30
 */
@Api(value = "用户",description = "用户")
@RestController
@RequestMapping(value = "user/")
public class UserController {


    @Autowired
    private UserService userService;

    @ApiOperation(value = "test", httpMethod = "GET")
    @GetMapping(value = "")
    public TestUser getUser(){
        TestUser testUser = userService.getUser();
        return testUser;
    }
}
