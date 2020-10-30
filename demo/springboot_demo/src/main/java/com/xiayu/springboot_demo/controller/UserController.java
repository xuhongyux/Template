package com.xiayu.springboot_demo.controller;

import com.xiayu.springboot_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/10/28 12:01
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    //@PostMapping()     @GetMapping(value = "selectUserByName/{userName}")
    @GetMapping(value = "createUser/{userName}/{password}/{tel}")
    public Integer createUser(@PathVariable String userName,@PathVariable String password,@PathVariable String tel){
        return userService.createUser(userName, password, tel);
    }
}