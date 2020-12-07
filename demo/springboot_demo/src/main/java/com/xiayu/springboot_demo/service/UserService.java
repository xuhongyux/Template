package com.xiayu.springboot_demo.service;

import com.xiayu.springboot_demo.domain.UserPo;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/10/28 11:58
 */
public interface UserService {
    /**
     * 创建用户
     * @param
     * @return
     */
    int createUser(@PathVariable String userName, @PathVariable String password, @PathVariable String tel);

    /**
     * 查询用户 by 用户名
     * @param userName
     * @return
     */
    UserPo selectUser(String userName);
}
