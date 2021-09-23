package com.xiayu.jvm.method;

/**
 * @author xuhongyu
 * @describe
 * 方法动态分派演示
 * @create 2021-09-23-10:03 上午
 */
public class DynamicDispatch {
    static abstract class Human {

        protected abstract void sayHello();

    }

    static class Man extends Human {

        @Override

        protected void sayHello() {

            System.out.println("man say hello");

        }

    }

    static class Woman extends Human {

        @Override

        protected void sayHello() {

            System.out.println("woman say hello");

        }

    }

    public static void main(String[] args) {

        Human man = new Man();

        Human woman = new Woman();

        man.sayHello();

        woman.sayHello();

        man = new Woman();

        man.sayHello();

    }


}