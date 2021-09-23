package com.xiayu.jvm.method;

/**
 * @author xuhongyu
 * @describe
 * 字段不参与多态
 * @create 2021-09-23-10:16 上午
 */
public class FieldHasNoPolymorphic {
    static class Father {

        public int money = 1;

        public Father() {

            money = 2;

            showMeTheMoney();

        }

        public void showMeTheMoney() {

            System.out.println("I am Father, i have $" + money);

        }

    }

    static class Son extends Father {

        public int money = 3;

        public Son() {

            money = 4;

            showMeTheMoney();

        }

        @Override
        public void showMeTheMoney() {

            System.out.println("I am Son, i have $" + money);

        }

    }

    public static void main(String[] args) {

        Father gay = new Son();

        System.out.println("This gay has $" + gay.money);

    }
}