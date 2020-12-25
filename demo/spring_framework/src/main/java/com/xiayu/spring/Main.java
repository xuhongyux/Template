package com.xiayu.spring;

import com.xiayu.spring.bean.BeanTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;

/**
 * @author xuhongyu
 * @describe
 * @create 2020-12-18-15:33
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("开始初始化");
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
        BeanTest beanPostProcessor = classPathXmlApplicationContext.getBean("test.bean.xiayu", BeanTest.class);
        String name = beanPostProcessor.getName();
        System.out.println(name);
    }
}
