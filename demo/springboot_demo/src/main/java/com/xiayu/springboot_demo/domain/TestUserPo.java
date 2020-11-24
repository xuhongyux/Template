package com.xiayu.springboot_demo.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author xuhongyu
 * @describe
 * @create 2020-11-23-15:14
 */
@Data
public class TestUserPo {
    private String id;
    private String name;
    private Integer type;
    private Integer role;
    private Date createTime;

}


