package com.xiayu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-02-04-18:42
 */
@RestController
public class UserController {

    // 查看所有博文
    @RequestMapping(value = "/admin/blogs", method = RequestMethod.GET)
    public String hello(String userName) {
       String str = "你好"+ userName + "!";
        return str;
    }

}
