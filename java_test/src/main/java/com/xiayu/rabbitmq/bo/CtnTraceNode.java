package com.xiayu.rabbitmq.bo;

/**
 * 轨迹节点枚举
 * @author lihao
 * @date 2021-09-03 10:24
 */
public enum CtnTraceNode {
    /**预录*/
    PRERECORD("预录"),
    /**进场*/
    CONTAINER_LOAD("进场"),
    /**运抵报文发送*/
    APPROACH_MSG_SEND("运抵报文发送"),
    /**查验*/
    CUSTOMS_INSPECTION("查验"),
    /**海放*/
    CUSTOMS_CLEARANCE("海放"),
    /**码放*/
    WHARF_CLEARANCE("码放"),
    /**出场*/
    CONTAINER_LEAVE("出场");

    private String name;

    CtnTraceNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
