package com.xiayu.springboot_demo.mapper;

import com.xiayu.springboot_demo.domain.TestUserRootPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xuhongyu
 * @describe
 * @create 2020-11-23-15:11
 */
@Mapper
public interface TestUserRootMapper {
    int insert(TestUserRootPo testUserRootPoPo);
}
