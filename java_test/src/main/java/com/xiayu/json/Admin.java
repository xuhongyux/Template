package com.xiayu.json;

import lombok.Data;

import java.util.List;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-08-09-3:34 下午
 */
@Data
public class Admin {
    String userName;

    List<Role> roles;
}