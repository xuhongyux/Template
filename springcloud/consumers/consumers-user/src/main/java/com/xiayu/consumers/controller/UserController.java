package com.xiayu.consumers.controller;

import com.xiayu.commons.entity.ResponseResult;
import com.xiayu.consumers.feignRemote.UserFeignRemote;
import com.xiayu.provider.api.UserService;
import com.xiayu.provider.domain.UserPo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
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
 * @Date 2020/10/3 11:39
 */
@Api(value = "User",description = "用户服务")
@RestController
@RequestMapping(value = "user/")
public class UserController {

    @Reference(version = "1.0.0")
    private UserService userService;

    @Autowired
    private UserFeignRemote userFeignRemote;


    @GetMapping(value = "selectUserByUserName/{userName}")
    @ApiOperation(value = "获取用户", httpMethod ="GET")
    public ResponseResult<UserPo> selectUserByUserName(@PathVariable String userName){
        UserPo userPo = userService.selectUserByName(userName);
        return  new ResponseResult<UserPo>(ResponseResult.CodeStatus.OK,"获取用户",userPo);
    }

    @GetMapping(value = "selectUserByUserNameFeign/{userName}")
    @ApiOperation(value = "获取用户-feign", httpMethod ="GET")
    public ResponseResult<String> selectUserByUserNameFeign(@PathVariable String userName){
        String userPo = userFeignRemote.selectUserByNamefeign();
        return  new ResponseResult<>(ResponseResult.CodeStatus.OK,"获取用户-feign",userPo);
    }
}
