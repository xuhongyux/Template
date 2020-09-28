package com.xiayu.oauth2.server.mapper;

import com.xiayu.oauth2.server.domain.TbPermission;
import com.xiayu.oauth2.server.domain.TbPermissionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbPermissionMapper {
    List<TbPermission> selectByUserId(@Param("userId") Long userId);

}