package com.xiayu.email.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-09-16-1:48 下午
 */
@Data
public class EasipassCustomsPushDataListDTO implements Serializable {

    public static final  String CUSTOMS_COMPLETE = "01";
    /**
     * 01 映射报关已完成
     */
    private String rspCode;
    private String rspText;
    private String voyage;
    private String blNo;
    private String entryNo;
    private String vslName;
    private String lastupdateddt;
}