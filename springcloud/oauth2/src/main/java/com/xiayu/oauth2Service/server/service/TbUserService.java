package com.xiayu.oauth2Service.server.service;

import com.xiayu.oauth2Service.server.domain.TbUser;
import com.xiayu.oauth2Service.server.domain.TbUserExample;
import com.xiayu.oauth2Service.server.mapper.TbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbUserService {

    @Autowired
    TbUserMapper tbUserMapper;
    /**
     * 通过名称获取用户信息
     * @param username
     * @return
     */
    public TbUser getByUsername(String username) {
        TbUserExample tbUserExample = new TbUserExample();
        tbUserExample.createCriteria().andUsernameEqualTo(username);
        List<TbUser> tbUsers = tbUserMapper.selectByExample(tbUserExample);
        if(tbUsers != null){
            return tbUsers.get(0);
        }
        return new TbUser();
    }



}
