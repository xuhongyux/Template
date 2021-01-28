package com.xiayu.log.jul;

import org.junit.Test;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-01-27-16:17
 */
public class JulTest {

    @Test
    public void testQuick() throws  Exception{
        //获取日志记录器对象
        Logger julLog = Logger.getLogger("JulTest");
        //日志记录器
        julLog.info("打印 info -日志");
        //通用的方式来记录日志
        julLog.log(Level.INFO,"打印日志");
        //通过占位符 方式来输出日志
        String name = "xiayu";
        Integer age = 18;
        julLog.log(Level.INFO,"用户名:{0},{1}",new Object[]{name,age});
    }

    /**
     * 日志级别
     * @throws Exception
     */
    @Test
    public void testLevel() throws  Exception{
        //获取日志记录器对象
        Logger julLog = Logger.getLogger("JulTest");

        julLog.severe("severe");
        julLog.warning("warning");
        julLog.info("info");
        //------------ 分隔符  默认的输出级别
        julLog.config("config");
        julLog.fine("fine");
        julLog.finer("finer");
        julLog.finest("finest");
    }
    @Test
    public void manualTest() throws Exception{
        //获取日志记录器对象
        Logger logger = Logger.getLogger("JulTest");
        //关闭默认日志级别
        logger.setUseParentHandlers(false);
        //输出到控制台
        ConsoleHandler consoleHandler = new ConsoleHandler();
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        consoleHandler.setFormatter(simpleFormatter);
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);
        //输出到文件
        FileHandler fileHandler = new FileHandler("jul.log");
        fileHandler.setFormatter(simpleFormatter);
        logger.addHandler(fileHandler);
        //日志级别
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");

    }
}
