package com.xiayu.springboot_demo.configuration;

import com.xiayu.springboot_demo.utils.SnowFlakeUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuhongyu
 * @describe
 * @create 2020-12-15-14:33
 */
@Configuration
public class ResourceConfiguration {

    @Value("${SnowFlake.datacenterId}")
    private long datacenterId;  //数据中心
    @Value("${SnowFlake.machineId}")
    private long machineId;    //机器标识

    @Bean
    public SnowFlakeUtil snowFlakeUtil(){
       return SnowFlakeUtil.getSnowFlakeUtil(datacenterId,machineId);
    }


}
