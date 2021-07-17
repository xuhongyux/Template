package com.xiayu.readfile;


import lombok.Data;

/**
 * @author xuhongyu
 * @create 2021-07-09 17:04
 */

@Data
public class InitCustomResultBo {

    private Long kpiId;

    private String functionName;

    private  String label;

    private Object saveResult;

    private String dateFilterCondition;

    private String filterCondition;

    private String path = "D:\\idea_work\\Template\\";

}
