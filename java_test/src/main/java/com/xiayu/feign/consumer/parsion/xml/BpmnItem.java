package com.xiayu.feign.consumer.parsion.xml;


import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * 每个bpmn模型的基础item
 *
 * @author lijinfeng
 * @date 2021年4月17日
 */

@ToString
@Data
public class BpmnItem {
    /**
     * 每一个bpmnItem的gateway（可以为空）
     */
    BpmnGatewayEnum gateway;

    /**
     * 当前 BpmnItem 中的活动
     */
    List<String> activities;

    /**
     * 当前bpmnitem所连接的下一个bpmn
     */
    List<BpmnItem> nextBpmnItems;


    public BpmnItem() {
        super();
        this.nextBpmnItems = new ArrayList();
        this.activities = new ArrayList();
        gateway = null;
    }


}
