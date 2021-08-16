package com.xiayu.controller;

import com.xiayu.domain.UserPlus;
import com.xiayu.entity.ResponseResult;
import com.xiayu.mapper.UserPlusMapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-08-13-6:01 下午
 */
@Slf4j
@RestController
public class MybatisPlusTestController extends  BaseController {
    @Autowired
    private UserPlusMapper userPlusMapper;


    @ApiOperation(value = "getAllUser", notes = "获取所以用户")
   @GetMapping("/getAllUser")
    public ResponseResult<List<UserPlus>> getAllUser(){
        try {

            List<UserPlus> userPluses = userPlusMapper.selectList(null);


            return new ResponseResult(200,"获取所以用户" ,"hello"+userPluses);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
            return new ResponseResult(500,"获取所以用户" ,null);
        }
    }
}