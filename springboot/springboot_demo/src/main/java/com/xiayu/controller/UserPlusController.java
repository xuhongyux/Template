package com.xiayu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiayu.api.IUserPlusService;
import com.xiayu.domain.UserPlus;
import com.xiayu.dto.GetUserDto;
import com.xiayu.entity.ResponseResult;
import com.xiayu.mapper.UserPlusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xiayu.controller.BaseController;

import java.sql.Wrapper;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xhy
 * @since 2021-08-16
 */
@RestController
@RequestMapping("/user-plus")
public class UserPlusController extends BaseController {


    @Autowired
    private IUserPlusService iUserPlusService;


    @PostMapping("/userTest")
    public ResponseResult<Object> userTest(@RequestBody GetUserDto getUserDto){

        UserPlus userPlus = new UserPlus();
        userPlus.setId(100L);
        userPlus.setName("testUser2");
        userPlus.setAge(0);
        userPlus.setEmail("sadfsa_2");

        boolean save = iUserPlusService.saveOrUpdate(userPlus);

        QueryWrapper<UserPlus> userPlusQueryWrapper = new QueryWrapper<>();
        userPlusQueryWrapper.eq("name","xiayu123");

        userPlusQueryWrapper.isNotNull("qrewer");


        QueryWrapper<UserPlus> objectQueryWrapper = new QueryWrapper<>();

        UserPlus one = iUserPlusService.getOne(userPlusQueryWrapper);

        int count = iUserPlusService.count();
        return new ResponseResult(200,"欢迎接口" ,one);
    }

    @GetMapping("/getAllUser")
    public ResponseResult<Object> getAllUser(){
        UserPlus userPlus = new UserPlus();

        userPlus.setName("testUser1");
        userPlus.setAge(0);
        userPlus.setEmail("sadfsa");

        boolean save = iUserPlusService.save(userPlus);

        return new ResponseResult(200,"欢迎接口" ,save);
    }



}
