package com.xiayu.provider.api;

import com.xiayu.provider.domain.TestUser;
import com.xiayu.provider.domain.UserPo;
import com.xiayu.provider.params.UserInsertVo;

import java.util.List;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/9/29 17:54
 */
public interface UserService {

    TestUser getUser();

    List<UserPo> getUsers();
    /**
     * 获取用户
     * @return
     */
    UserPo selectUserByName(String userName);

    void insert(UserInsertVo userInsertVo);
}
