package com.xiayu.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
@describe
@author xuhongyu
@create 2020-12-16-11:23
*/
@ApiModel(value="com-xiayu-provider-domain-Order")
@Data
public class OrderPo implements Serializable {
    /**
    * id
    */
    @ApiModelProperty(value="id")
    private String id;

    /**
    * 登录名称
    */
    @ApiModelProperty(value="登录名称")
    private String userId;

    /**
    * 信息
    */
    @ApiModelProperty(value="信息")
    private String information;

    /**
    * 订单类型，
    */
    @ApiModelProperty(value="订单类型，")
    private Integer type;

    /**
    * 订单状态，0 新建，1 正常 ，2 禁用 ，3 注销
    */
    @ApiModelProperty(value="订单状态，0 新建，1 正常 ，2 禁用 ，3 注销")
    private Integer orderStatus;

    /**
    * 最后登录时间
    */
    @ApiModelProperty(value="最后登录时间")
    private Date lastTime;

    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
    * 更新时间
    */
    @ApiModelProperty(value="更新时间")
    private Date updateTime;

    /**
    * 删除标志，0 未删除，1 已删除
    */
    @ApiModelProperty(value="删除标志，0 未删除，1 已删除")
    private Integer delFlag;

    private static final long serialVersionUID = 1L;
}