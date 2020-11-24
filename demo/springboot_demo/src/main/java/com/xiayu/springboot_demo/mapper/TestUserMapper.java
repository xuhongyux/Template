package com.xiayu.springboot_demo.mapper;

import com.xiayu.springboot_demo.domain.TestUserPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xuhongyu
 * @describe
 * @create 2020-11-23-15:11
 */
@Mapper
public interface TestUserMapper {
    int insert(TestUserPo testUserPo);
}
