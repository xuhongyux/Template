package com.xiayu.log.configuration;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/2/19 11:55
 */
@Data
public class Log {
     public Log(String logType, Long time){
         this.logType = logType;
         this.time = time;
     }
    //描述
    private String description;
    //方法名
    private String method;
    //参数
    private String params;
    //日志类型
    private String logType;
    //请求ip
    private String requestIp;
    //请求耗时
    private Long time;
    //异常详细
    private String exceptionDetail;
    //请求实践
    private Timestamp createTime;

}
