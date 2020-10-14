package com.xiayu.oauth2Service.server.mapper;

import com.xiayu.oauth2Service.server.domain.TbPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbPermissionMapper {
    List<TbPermission> selectByUserId(@Param("userId") Long userId);

}