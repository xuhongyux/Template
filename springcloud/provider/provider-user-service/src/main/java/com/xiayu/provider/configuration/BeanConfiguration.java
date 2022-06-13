//package com.xiayu.provider.configuration;
//
//
//import com.xiayu.commons.utils.SnowFlakeUtil;
//import com.xiayu.log.configuration.RequestTimeAspect;
//import com.xiayu.swagger.configuration.Swagger2Configuration;
//import com.xiayu.transaction.configuration.TxAnoConfig;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
///**
// * Description:
// *
// * @version v1.0.0
// * @Author xiayu
// * @Date 2020/10/15 19:35
// */
//
//
///**
// * 扫描其他路径下的配置配置文件
// * TxAnoConfig 全局事务处理
// * RequestTimeAspect 全局日志
// * swagger2 全局配置
// */
//@ComponentScan(basePackageClasses= {TxAnoConfig.class, RequestTimeAspect.class, Swagger2Configuration.class})
//@Configuration
//public class BeanConfiguration {
//    @Value("${SnowFlake.datacenterId}")
//    private long datacenterId;  //数据中心
//    @Value("${SnowFlake.machineId}")
//    private long machineId;    //机器标识
//
//
//    @Bean
//    public SnowFlakeUtil snowFlakeUtil(){
//        return SnowFlakeUtil.getSnowFlakeUtil(datacenterId,machineId);
//    }
//
//}
