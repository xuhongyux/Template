package com.xiayu.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-02-02-12:42
 */
public class Test {


    /**
     *
     *  public Constructor getConstructor(Class... parameterTypes):获取单个的"公有的"构造方法：
     *  public Constructor getDeclaredConstructor(Class... parameterTypes):获取"某个构造方法"可以是私有的，或受保护、默认、公有；
     * @param args
     */

    public static void main(String[] args) {
        try {
            /*以下调用无参的、私有构造函数*/
            Class<?> userpo = Class.forName("com.xiayu.reflection.UserPo");
            //设置构造方法的 安全等级
            Constructor<?> declaredConstructor = userpo.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            Object o2 = declaredConstructor.newInstance();





            /*以下调用带参的、私有构造函数*/
            Class<?> userPoParam = Class.forName("com.xiayu.reflection.UserPo");
            Constructor<?> declaredConstructor1 = userPoParam.getDeclaredConstructor(String.class);
            declaredConstructor1.setAccessible(true);
            Object o1 = declaredConstructor1.newInstance("123");

            /**
             * 有参  public
             */
            Class<?> userPoParamPublic = Class.forName("com.xiayu.reflection.UserPo");
            Constructor con = userPoParamPublic.getConstructor(String.class,int.class);
            Object o = con.newInstance("123", "123");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
