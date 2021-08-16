package com.xiayu.provider.params;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author xuhongyu
 * @describe
 * @create 2020-12-16-11:42
 */
public class OrderVo {
    private String id;

    @ApiModelProperty(value="登录名称")
    private String userId;

    @ApiModelProperty(value="信息")
    private String information;

    @ApiModelProperty(value="订单类型，")
    private Integer type;

    @ApiModelProperty(value="订单状态，0 新建，1 正常 ，2 禁用 ，3 注销")
    private Integer orderStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
}
