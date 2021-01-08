package com.xiayu.provider.controller;

import com.xiayu.commons.entity.ResponseResult;
import com.xiayu.commons.utils.SnowFlakeUtil;
import com.xiayu.provider.api.UserService;
import com.xiayu.provider.domain.UserPo;
import com.xiayu.provider.params.UserInsertVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/9/29 15:30
 */
@Api(value = "用户", description = "用户")
@RestController
@RequestMapping(value = "user/")
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    private SnowFlakeUtil snowFlakeUtil;

    @ApiOperation(value = "test", httpMethod = "GET")
    @GetMapping(value = "")
    public List<UserPo> getUser() {
        return userService.getUsers();
    }

    @ApiOperation(value = "查找用户", httpMethod = "GET")
    @GetMapping(value = "selectUserByName/{userName}")
    public UserPo selectUserByName(@PathVariable String userName) {
        return userService.selectUserByName(userName);
    }


    @GetMapping(value = "selectUserByNameFeign")
    public String selectUserByNamefeign() {
        return userService.selectUserByName("夏雨").toString();
    }
    @ApiOperation(value = "添加用户", httpMethod = "POST")
    @PostMapping(value = "creatUser")
    public ResponseResult<Void> creatUser(@RequestBody UserInsertVo userInsertVo) {
        userService.insert(userInsertVo);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "添加用户", null);

    }
    @ApiOperation(value = "更新用户信息",httpMethod = "POST")
    @PostMapping(value = "updateUser")
    public ResponseResult<Void> updateUser(@RequestBody UserInsertVo userInsertVo){
        userService.updateUser(userInsertVo);
        return  new ResponseResult<>(ResponseResult.CodeStatus.OK,"更新用户信息");
    }



    @ApiOperation(value = "测试雪花算法", httpMethod = "GET")
    @GetMapping(value = "SnowFlakeUtilTest")
    public ResponseResult<Long> SnowFlakeUtilTest(){
        long l = snowFlakeUtil.nextId();
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"",l);
    }

}
