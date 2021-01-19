package com.xiayu.springboot_demo.service.impl;

import com.xiayu.springboot_demo.domain.UserPo;
import com.xiayu.springboot_demo.mapper.UserBeanMapper;
import com.xiayu.springboot_demo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2021/1/19 19:50
 */
@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private UserBeanMapper userBeanMapper;

    @Override
    @Cacheable(cacheNames = {"userName"})
    public UserPo selectUserByUserName(String userName){
        UserPo userPo = userBeanMapper.selectUserByUserName(userName);
        System.out.println("____________________________________________");
        UserPo userPo2 = userBeanMapper.selectUserByUserName(userName);
        return userPo;
    }


}


