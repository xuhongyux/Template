package com.xiayu.feign.consumer.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiayu.feign.consumer.api.IUserPlusService;
import com.xiayu.feign.consumer.domain.UserPlus;
import com.xiayu.feign.consumer.entity.ResponseResult;
import com.xiayu.feign.consumer.mapper.UserPlusMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-08-25-1:23 下午
 */

@RestController
@RequestMapping("/mybatisPlusController")
public class MybatisPlusController {


    @Autowired
    private IUserPlusService iUserPlusService;


    @Autowired
    UserPlusMapper userPlus;

    IUserPlusService userPlusService;

    @ApiOperation(value = "查找", notes = "")
    @PostMapping("/select")
    public ResponseResult<Object> select(@RequestParam Long page,@RequestParam Long size){
        /**
         * 分页 页码从1开始
         */
        Page<UserPlus> pageOb = new Page<>(page, size);

        /**
         * 条件
         * eq  等一
         */
        QueryWrapper<UserPlus> userPlusQueryWrapper = new QueryWrapper<>();
        userPlusQueryWrapper.orderByAsc("age");

        Page<UserPlus> userPlusPage = userPlus.selectPage(pageOb, userPlusQueryWrapper);

        return new ResponseResult(200,"查找" ,userPlusPage);
    }



    @ApiOperation(value = "更新接口", notes = "")
    @PostMapping("/update")
    public ResponseResult<Object> updateUser(@RequestParam String userName, @RequestParam Long age){

        UpdateWrapper<UserPlus> userPlusUpdateWrapper = new UpdateWrapper<>();
        userPlusUpdateWrapper.set("email","laonianren");
        userPlusUpdateWrapper.ge("age",40);

        int update = this.userPlus.update(null, userPlusUpdateWrapper);
        return new ResponseResult(200,"更新接口" ,update);
    }

    @ApiOperation(value = "插入接口", notes = "")
    @PostMapping("/save")
    public ResponseResult<Object> saveUser(@RequestParam String userName, @RequestParam Long age){
        UserPlus userPlus = new UserPlus();
        userPlus.setId(88L);
        userPlus.setAge(88);
        userPlus.setName("daidai");
        userPlus.setEmail("feiwu");
        boolean save = this.iUserPlusService.save(userPlus);
        return new ResponseResult(200,"更新接口" ,save);
    }


    @ApiOperation(value = "手写xml接口", notes = "")
    @PostMapping("/xmlSelect")
    public ResponseResult<Object> xmlSelect(@RequestParam String userName, @RequestParam Long id){
        if (StringUtils.isBlank(userName)) {
            userName = "";
        }
        String userNameById = userPlus.getUserNameById(id,userName);
        List<Long> objects = new ArrayList<>();
        objects.add(3L);
        objects.add(17L);
        List<String> userNameByAge = userPlus.getUserNameByAge(objects);
        return new ResponseResult(200,"更新接口" ,userNameById);
    }



}