package com.xiayu.springboot_demo.service.impl;

import com.xiayu.springboot_demo.domain.UserExample;
import com.xiayu.springboot_demo.domain.UserPo;
import com.xiayu.springboot_demo.mapper.UserMapper;
import com.xiayu.springboot_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/10/28 11:58
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;



    @Override
    public int createUser(String userName, String password, String tel) {
        Date date = new Date();
        UserPo userPo = new UserPo();
        userPo.setId(buildUUID());
        userPo.setLoginName(userName);
        userPo.setPassword(password);
        userPo.setType(1);
        userPo.setTel(tel);
        userPo.setUserStatus(0);
        userPo.setLastTime(date);
        userPo.setCreateTime(date);
        userPo.setUpdateTime(date);
        userPo.setDelFlag(0);

        int insert = userMapper.insert(userPo);

       /* if(true){
            RuntimeException runtimeException = new RuntimeException("手动生成异常");
            throw runtimeException;
        }*/
        return insert;
    }

    @Override
    @Cacheable(value ="UserPo", key = "#userName")
    public UserPo selectUser(String userName) {

        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andLoginNameEqualTo(userName)
                .andDelFlagEqualTo(0);
        List<UserPo> userPos = userMapper.selectByExample(userExample);

        return userPos.size()==0? new UserPo(): userPos.get(0);
    }

    public List<UserPo> mapperSelectUser(){
        UserPo userPo = new UserPo();
        userPo.setLoginName("夏雨");
        List<UserPo> userPo1 = userMapper.mapperSelectUser(userPo);
        return userPo1;
    }

    /**
     * 生成一个UUID
     *
     * @return
     */
    public static String buildUUID() {
        //replace 替代
        return UUID.randomUUID().toString().replace("-", "");
    }
}
