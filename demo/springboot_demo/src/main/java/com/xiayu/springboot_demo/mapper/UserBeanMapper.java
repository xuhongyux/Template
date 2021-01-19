package com.xiayu.springboot_demo.mapper;

import com.xiayu.springboot_demo.domain.UserPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2021/1/19 19:36
 */
@Mapper
public interface UserBeanMapper {
    UserPo selectUserByUserName(@Param("userName") String userName);
}
