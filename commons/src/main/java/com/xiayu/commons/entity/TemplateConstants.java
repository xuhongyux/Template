package com.xiayu.commons.entity;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2019/12/26 21:43
 */
public class TemplateConstants {

    public TemplateConstants() {
    }



    public static final Integer SMS_TYPE_MESSAGE = 3;
    public static final Integer SMS_TYPE_REGISTER = 2;
    public static final Integer SMS_TYPE_LOGIN = 1;

    //公共常量
    public static final String BLANK_CHARACTER = " ";
    public static final String BLANK = "";
    public static final String DOT = ".";
    public static final String COMMA=",";
    public static final String PER_CENT="%";
    public static final String HG="-";
    public static final boolean FLAG_FALSE=false;
    public static final boolean FLAG_TRUE=true;



    /**
     * 删除标志 0未删除
     */
    public final static Integer DELFLAG = 0;

    /**
     * 删除标志 1删除
     */
    public final static Integer DELFLAG_OK = 1;

    /**
     * 用户状态1 新建
     */
    public final static Integer USERSTATUSNEW = 1;
    /**
     * 用户状态2 禁用
     */
    public final static Integer USERSTATUSDISABLE = 2;
    /**
     * 用户状态3 正常
     */
    public final static Integer USE_STATUS = 3;

    /**
     * 用户类型 默认0
     */
    public final static Integer USERTYPE = 0;

    //公共数据
    //常量数字0.00
    public static final double DOUBLE_0=0.00;
    //常量数字1
    public static final int NUM_1=1;
    public static final String STRING_NUM_1="1";
    //常量数字2
    public static final int NUM_2=2;
    //常量数字3
    public static final int NUM_3=3;
    //常量数字4
    public static final int NUM_4=4;
    //常量数字5
    public static final int NUM_5=5;
    //常量数字6
    public static final int NUM_6=6;
    //常量数字7
    public static final int NUM_7=7;
    //常量数字8
    public static final int NUM_8=8;
    //常量数字9
    public static final int NUM_9=9;
    //常量数字0
    public static final int NUM_0=0;
    //性别男
    public static final int SEX_MAN=1;
    //性别女
    public static final int SEX_WOMAN=2;
    //性别未知
    public static final int SEX_UNKNOWN=9;
    //男
    public static final String MAN = "男";
    //女
    public static final String WOMAN = "女";
    //0 未分配 ，1已分配
    public static final int IS_ALLOT_0=0;
    public static final int IS_ALLOT_1=1;

    //错误提示
    /**
     * 请求失败返回信息
     */
    public static final String BREAKING_MESSAGE = "您的网络真的有问题，你再检查检查";

    /**
     * 触发熔断
     */
    public static final String TRIGGER_FUSING ="触发熔断";

}
