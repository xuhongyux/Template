package com.xiayu.springboot_demo.service;

import com.xiayu.springboot_demo.domain.UserPo;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2021/1/19 19:50
 */
public interface DataService {
    UserPo selectUserByUserName(String userName);
}
