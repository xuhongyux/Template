package com.xiayu.oauth.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.xiayu.oauth.domain.TbUser;
import com.xiayu.oauth.mapper.TbUserMapper;
import com.xiayu.oauth.service.TbUserService;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/9/29 13:11
 */
@Service
public class TbUserServiceImpl implements TbUserService {

    @Resource
    private TbUserMapper tbUserMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return tbUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TbUser record) {
        return tbUserMapper.insert(record);
    }

    @Override
    public int insertSelective(TbUser record) {
        return tbUserMapper.insertSelective(record);
    }

    @Override
    public TbUser selectByPrimaryKey(Long id) {
        return tbUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TbUser record) {
        return tbUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TbUser record) {
        return tbUserMapper.updateByPrimaryKey(record);
    }

}


