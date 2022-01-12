package com.xiayu.demo.service;

import com.xiayu.demo.domain.UserPlus;
import com.xiayu.demo.mapper.UserPlusMapper;
import com.xiayu.demo.api.IUserPlusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuhongyu
 * @since 2021-12-08
 */
@Service
@Transactional
public class UserPlusServiceImpl extends ServiceImpl<UserPlusMapper, UserPlus> implements IUserPlusService {

    @Autowired
    UserPlusServiceImpl userPlusService;

}
