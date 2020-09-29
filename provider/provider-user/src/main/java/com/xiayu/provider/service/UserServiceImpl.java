package com.xiayu.provider.service;


import com.xiayu.provider.api.UserService;
import com.xiayu.provider.domain.TestUser;
import com.xiayu.provider.mapper.TestUserMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

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
    private TestUserMapper userMapper;


    @Override
    public TestUser getUser() {
        TestUser testUser = userMapper.selectByPrimaryKey(1L);
        return testUser;
    }
}
