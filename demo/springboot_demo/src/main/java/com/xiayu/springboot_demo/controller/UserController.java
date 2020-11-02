package com.xiayu.springboot_demo.controller;

import com.xiayu.springboot_demo.entity.ResponseResult;
import com.xiayu.springboot_demo.service.UserService;
import com.xiayu.springboot_demo.utils.IPUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/10/28 12:01
 */
@Api(tags = "用户")
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    //@PostMapping()     @GetMapping(value = "selectUserByName/{userName}")
    @ApiOperation("添加用户")
    @GetMapping(value = "createUser/{userName}/{password}/{tel}")
    public ResponseResult<Integer> createUser(@PathVariable String userName, @PathVariable String password, @PathVariable String tel, HttpServletRequest request ) throws InterruptedException {

        int user = userService.createUser(userName, password, tel);
        return new ResponseResult(ResponseResult.CodeStatus.OK,"添加用户",user);
    }
}
