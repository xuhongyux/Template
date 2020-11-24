package com.xiayu.proxy;

/**
 * @author xuhongyu
 * @describe
 * @create 2020-11-20-17:24
 */
public class PersonProxy implements  IPerson {

    private final Person person ;

    public PersonProxy(Person person){
        this.person = person;
    }

    @Override
    public void eat() {
        this.person.eat();
    }

    @Override
    public void sleep() {
    this.person.sleep();
    }
}
