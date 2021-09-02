//package com.xiayu.log.log4j;
//
//
//import org.apache.log4j.BasicConfigurator;
//import  org.apache.log4j.Logger;
//import org.junit.Test;
//
///**
// * @author xuhongyu
// * @describe
// * @create 2021-01-28-9:14
// */
//public class Log4jTest {
//
//
//    @Test
//    public  void  log4j(){
//        //初始化信息，暂时不使用配置文件配置，采用代码配置
//        BasicConfigurator.configure();
//        // 创建日志记录器对象
//        Logger logger = Logger.getLogger(Log4jTest.class);
//        logger.error("Log4jTest -----error");
//        logger.info("Log4jTest -----info");
//        logger.debug("Log4jTest -----debug");
//        logger.warn("Log4jTest -----warn");
//        logger.trace("Log4jTest ----trace");
//        logger.fatal("Log4jTest -----fatal");
//    }
//}
