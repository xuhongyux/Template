package com.xiayu.springboot_jar.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiayu.springboot_jar.domain.UserPlus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-08-13-5:59 下午
 */
public interface UserPlusMapper extends BaseMapper<UserPlus> {


    /**
     * 修改参数
     * @param userName
     * @param age
     * @return
     */
    Integer updateUserByName(@Param("userName") String userName,
                                   @Param("age") Long age);

    /**
     * 根据id 获取姓名
     * @param id
     * @return
     */
    String getUserNameById(@Param("id") Long id, @Param("name") String name);

    List<String> getUserNameByAge(@Param("ages") List<Long> ages);

}