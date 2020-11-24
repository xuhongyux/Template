package com.xiayu.proxy;

/**
 * @author xuhongyu
 * @describe
 * @create 2020-11-20-17:23
 */
public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        person.eat();
        person.sleep();
    }
    @org.junit.Test
    public void proxy(){
        Person person = new Person();
        PersonProxy personProxy = new PersonProxy(person);
        personProxy.sleep();
        personProxy.eat();
    }
}


