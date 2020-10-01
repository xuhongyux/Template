package com.xiayu.provider.service;


import com.xiayu.commons.utils.MapperUtils;
import com.xiayu.provider.api.UserService;
import com.xiayu.provider.domain.TestUser;
import com.xiayu.provider.domain.User;
import com.xiayu.provider.domain.UserExample;
import com.xiayu.provider.mapper.TestUserMapper;
import com.xiayu.provider.mapper.UserMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/9/29 17:52
 */

@Service(version = "1.0.0", timeout = 30000)
public class UserServiceImpl implements UserService {

    @Autowired
    private TestUserMapper testUserMapper;

    @Autowired
    private UserMapper userMapper;


    @Override
    public TestUser getUser() {
        TestUser testUser = testUserMapper.selectByPrimaryKey(1L);
        return testUser;
    }


    @Override
    public List<User> getUsers() {
        UserExample userExample = new UserExample();
        userExample.createCriteria();
        List<User> users = userMapper.selectByExample(userExample);
        if(!MapperUtils.isBlankCollection(users)){
            return users;
        }
        return null;

    }
}
