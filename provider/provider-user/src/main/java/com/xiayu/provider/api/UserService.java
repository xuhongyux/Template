package com.xiayu.provider.api;

import com.xiayu.provider.domain.TestUser;
import com.xiayu.provider.domain.User;

import java.util.List;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/9/29 17:54
 */
public interface UserService {
    /**
     * 获取用户
     * @return
     */
    TestUser getUser();

    List<User> getUsers();
}
