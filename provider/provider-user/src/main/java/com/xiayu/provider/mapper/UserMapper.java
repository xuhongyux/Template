package com.xiayu.provider.mapper;

import com.xiayu.provider.domain.User;
import com.xiayu.provider.domain.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * Description: 
 * 
 * @Author xiayu
 * @Date 2020/10/1 13:22
 * @version v1.0.0
 */
public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}