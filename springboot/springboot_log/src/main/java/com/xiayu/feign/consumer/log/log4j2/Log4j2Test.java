//package com.xiayu.log.log4j2;
//
//
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.junit.Test;
//
///**
// * @author xuhongyu
// * @describe
// * @create 2021-01-28-11:14
// */
//public class Log4j2Test {
//    public static final Logger LOGGER = LogManager.getLogger(Log4j2Test.class);
//
//    @Test
//    public void log4j2() {
//        //打印日志信息
//        LOGGER.error("error");
//        LOGGER.warn("warn");
//        LOGGER.info("info");
//        LOGGER.debug("debug");
//        LOGGER.trace("trace");
//        // 使用占位符输出日志信息
//        String name = "jack";
//        Integer age = 18;
//        LOGGER.info("用户：{},{}", name, age);
//        // 将系统异常信息写入日志
//        try {
//            int i = 1 / 0;
//        } catch (Exception e) {
//            // e.printStackTrace();
//            LOGGER.info("出现异常：", e);
//        }
//    }
//}
