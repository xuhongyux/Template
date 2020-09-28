package com.xiayu.oauth.mapper;

import com.xiayu.oauth.domain.UserVo;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/9/26 19:50
 */
public interface UserMapper extends Mapper<UserVo> {
    @Select("SELECT * FROM user")
    public List<UserVo> getUser();
}
