package com.xiayu.springboot_demo.domain;



import lombok.Data;

import java.util.Date;

/**
 * 
 * Description: 
 * 
 * @Author xiayu
 * @Date 2020/10/1 13:22
 * @version v1.0.0
 */
@Data
public class UserPo {

    /**
    * id
    */
    private String id;

    /**
    * 登录名称
    */
    private String loginName;

    /**
    * 账号
    */
    private String password;

    /**
    * 用户类型，0 超级管理员，1 管理员 ，2 操作人员
    */
    private Integer type;

    /**
    * 电话
    */
    private String tel;

    /**
    * 编号
    */
    private String userNumber;

    /**
    * 用户状态，0 新建，1 正常 ，2 禁用 ，3 注销
    */
    private Integer userStatus;

    /**
    * 最后登录时间
    */
    private Date lastTime;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 更新时间
    */
    private Date updateTime;

    /**
    * 删除标志，0 未删除，1 已删除
    */
    private Integer delFlag;
}