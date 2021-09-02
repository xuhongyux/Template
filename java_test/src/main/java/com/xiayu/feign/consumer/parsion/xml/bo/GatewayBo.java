package com.xiayu.feign.consumer.parsion.xml.bo;

import lombok.Data;

import java.util.List;

/**
 * @author xuhongyu
 * @create 2021-04-19 17:07
 */
@Data
public class GatewayBo {
    String id;

    String name;

    List<String> incomingList;

    List<String> outgoing;

    String gateWayType;

}
