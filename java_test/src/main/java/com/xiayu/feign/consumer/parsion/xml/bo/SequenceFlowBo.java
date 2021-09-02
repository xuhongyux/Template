package com.xiayu.feign.consumer.parsion.xml.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author xuhongyu
 * @create 2021-04-19 15:36
 */
@Data
@AllArgsConstructor
public class SequenceFlowBo {
    String id;

    /**
     * 来源ID
     */
    String sourceRef;

    /**
     * 目标ID
     */
    String targetRef;
}
