package com.xiayu.feign.consumer.parsion.xml.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author xuhongyu
 * @create 2021-04-19 16:23
 */
@Data
@AllArgsConstructor
public class TaskBo {
    String id;

    String name;

    List<String> incomingList;

    List<String> outgoing;

    public TaskBo(){

    }
}
