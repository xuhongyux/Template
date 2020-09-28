package com.xiayu.oauth2.server.service;

import com.xiayu.oauth2.server.domain.TbPermission;
import com.xiayu.oauth2.server.domain.TbPermissionExample;
import com.xiayu.oauth2.server.mapper.TbPermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbPermissionService {


    @Autowired
    TbPermissionMapper tbPermissionMapper;

    /**
     * 通过用户ID来获取权限信息
     * @param id
     * @return
     */
    public List<TbPermission> selectByUserId(Long id) {
        return tbPermissionMapper.selectByUserId(id);
    }
}
