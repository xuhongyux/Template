package com.xiayu.spring.bean;

import org.springframework.beans.factory.InitializingBean;

import java.io.Serializable;

/**
 * @author xuhongyu
 * @describe
 * @create 2020-12-18-15:16
 */
public class BeanTest implements Serializable {
 private String name;

 private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
