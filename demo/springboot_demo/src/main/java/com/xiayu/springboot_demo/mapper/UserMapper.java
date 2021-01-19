package com.xiayu.springboot_demo.mapper;



import java.util.List;

import com.xiayu.springboot_demo.domain.UserExample;
import com.xiayu.springboot_demo.domain.UserPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 *
 * Description:
 *
 * @Author xiayu
 * @Date 2020/10/1 13:22
 * @version v1.0.0
 */
@Mapper
public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserPo record);

    int insertSelective(UserPo record);

    List<UserPo> selectByExample(UserExample example);

    UserPo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserPo record, @Param("example") UserExample example);

    int updateByExample(@Param("record") UserPo record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(UserPo record);

    int updateByPrimaryKey(UserPo record);

    List<UserPo> mapperSelectUser(UserPo userPo);
}