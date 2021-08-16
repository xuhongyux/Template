package com.xiayu.springboot_demo.controller;

import com.xiayu.springboot_demo.domain.TestUserPo;
import com.xiayu.springboot_demo.domain.TestUserRootPo;
import com.xiayu.springboot_demo.domain.UserPo;
import com.xiayu.springboot_demo.entity.ResponseResult;
import com.xiayu.springboot_demo.mapper.TestUserMapper;
import com.xiayu.springboot_demo.mapper.TestUserRootMapper;
import com.xiayu.springboot_demo.mapper.UserBeanMapper;
import com.xiayu.springboot_demo.service.DataService;
import com.xiayu.springboot_demo.utils.MapperUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author xuhongyu
 * @describe
 * @create 2020-11-23-15:18
 */
@Api(tags = "数据库")
@RestController
@RequestMapping("data/")
public class DataController {

    @Autowired
    private UserBeanMapper userBeanMapper;

    @Autowired
    private TestUserMapper testUserMapper;

    @Autowired
    private TestUserRootMapper testUserRootMapper;

    @Autowired
    private DataService dataService;

    @ApiOperation("Mybatis缓存一级缓存")
    @GetMapping(value = "mybatisCache/{userName}")
    public ResponseResult<UserPo> mybatisCache(@PathVariable String userName) {
        UserPo userPo = dataService.selectUserByUserName(userName);
        return new ResponseResult<UserPo>(ResponseResult.CodeStatus.OK, "Mybatis缓存", userPo);
    }

    @ApiOperation("添加用户权限")
    @GetMapping(value = "createUserRoot")
    public ResponseResult<Integer> createUserRoot() {

        int code = 0;
        List<TestUserRootPo> testUserPoList1 = new ArrayList<>();
        List<TestUserRootPo> testUserPoList2 = new ArrayList<>();
        List<TestUserRootPo> testUserPoList3 = new ArrayList<>();
        List<TestUserRootPo> testUserPoList4 = new ArrayList<>();
        List<TestUserRootPo> testUserPoList5 = new ArrayList<>();

        for (int i = 0; i < 5000; i++) {
            code++;
            TestUserRootPo testUserPo = new TestUserRootPo();
            testUserPo.setId(MapperUtils.buildUUID());
            testUserPo.setName("权限" + code);
            testUserPo.setType(1);
            testUserPo.setRoot(getRandom());
            switch (i % 5) {
                case 1:
                    testUserPoList1.add(testUserPo);
                    break;
                case 2:
                    testUserPoList2.add(testUserPo);
                    break;
                case 3:
                    testUserPoList3.add(testUserPo);
                    break;
                case 4:
                    testUserPoList4.add(testUserPo);
                    break;
                default:
                    testUserPoList5.add(testUserPo);
                    break;
            }
        }
        System.out.println("ok");

        new Thread(
                () -> {
                    for (TestUserRootPo testUserPo : testUserPoList1) {
                        testUserRootMapper.insert(testUserPo);
                    }
                }
        ).start();

        new Thread(
                () -> {
                    for (TestUserRootPo testUserPo : testUserPoList2) {
                        testUserRootMapper.insert(testUserPo);
                    }
                }
        ).start();
        new Thread(
                () -> {
                    for (TestUserRootPo testUserPo : testUserPoList3) {
                        testUserRootMapper.insert(testUserPo);
                    }
                }
        ).start();
        new Thread(
                () -> {
                    for (TestUserRootPo testUserPo : testUserPoList4) {
                        testUserRootMapper.insert(testUserPo);
                    }
                }
        ).start();
        new Thread(
                () -> {
                    for (TestUserRootPo testUserPo : testUserPoList5) {
                        testUserRootMapper.insert(testUserPo);
                    }
                }
        ).start();


        return new ResponseResult(ResponseResult.CodeStatus.OK, "添加用户权限", null);
    }


    @ApiOperation("添加用户")
    @GetMapping(value = "createUser")
    public ResponseResult<Integer> createUser() {
        int code = 0;
        List<TestUserPo> testUserPoList1 = new ArrayList<>();
        List<TestUserPo> testUserPoList2 = new ArrayList<>();
        List<TestUserPo> testUserPoList3 = new ArrayList<>();
        List<TestUserPo> testUserPoList4 = new ArrayList<>();
        List<TestUserPo> testUserPoList5 = new ArrayList<>();

        for (int i = 0; i < 5000; i++) {
            code++;
            TestUserPo testUserPo = new TestUserPo();
            testUserPo.setId(MapperUtils.buildUUID());
            testUserPo.setName("夏雨" + code);
            testUserPo.setType(1);
            testUserPo.setRole(getRandom());
            testUserPo.setCreateTime(new Date());
            switch (i % 5) {
                case 1:
                    testUserPoList1.add(testUserPo);
                    break;
                case 2:
                    testUserPoList2.add(testUserPo);
                    break;
                case 3:
                    testUserPoList3.add(testUserPo);
                    break;
                case 4:
                    testUserPoList4.add(testUserPo);
                    break;
                default:
                    testUserPoList5.add(testUserPo);
                    break;
            }
        }
        System.out.println("ok");

        new Thread(
                () -> {
                    for (TestUserPo testUserPo : testUserPoList1) {
                        testUserMapper.insert(testUserPo);
                    }
                }
        ).start();

        new Thread(
                () -> {
                    for (TestUserPo testUserPo : testUserPoList2) {
                        testUserMapper.insert(testUserPo);
                    }
                }
        ).start();
        new Thread(
                () -> {
                    for (TestUserPo testUserPo : testUserPoList3) {
                        testUserMapper.insert(testUserPo);
                    }
                }
        ).start();
        new Thread(
                () -> {
                    for (TestUserPo testUserPo : testUserPoList4) {
                        testUserMapper.insert(testUserPo);
                    }
                }
        ).start();
        new Thread(
                () -> {
                    for (TestUserPo testUserPo : testUserPoList5) {
                        testUserMapper.insert(testUserPo);
                    }
                }
        ).start();


        return new ResponseResult(ResponseResult.CodeStatus.OK, "添加用户", null);
    }

    private Integer getRandom() {
        int max = 4;
        int min = 0;
        Random random = new Random();

        int s = random.nextInt(max) % (max - min + 1) + min;
        return s;
    }
}
