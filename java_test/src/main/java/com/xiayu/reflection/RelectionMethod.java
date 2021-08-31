package com.xiayu.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author xuhongyu
 * @describe  Java 反射相关API
 * @create 2021-02-02-18:42
 */
public class RelectionMethod {
    public static void main(String[] args) throws Exception {

        Class<?> userPoClass = Class.forName("com.xiayu.reflection.UserPo");

        String name2 = userPoClass.getName();
        System.out.println(name2);
        /**
         * 返回这个类或者超类的共有域
         */
        Field[] fields = userPoClass.getFields();

        /**
         * 返回这个类或者超类的所有方法
         */
        Method[] methods = userPoClass.getMethods();

        /**
         * 返回这个类或者超类的所有构造器(public)
         */
        Constructor<?>[] constructors = userPoClass.getConstructors();


        /**
         * 获取构造器对象
         */
        Constructor<?> declaredConstructor = userPoClass.getDeclaredConstructor();
        //设置为public
        declaredConstructor.setAccessible(true);
        // 返回用于表述类中定义的构造器，方法或域的class对象
        Class<?> declaringClass = declaredConstructor.getDeclaringClass();
        // 返回一类类型数组
        Class<?>[] exceptionTypes = declaredConstructor.getExceptionTypes();
        //返回一个用于描述方法抛出的异常类型的class对象数组
        int modifiers = declaredConstructor.getModifiers();
        //返回一个用户描述构造器，方法或者域的字符串
        String name = declaredConstructor.getName();
        //返回 参数类型数组
        Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();


        /**
         * 获取一个方法
         */
        Method toString = userPoClass.getMethod("toString");
        //返回描述返回类型的 class对象
        Class<?> returnType = toString.getReturnType();

        /**
         * field 域操作
         */
        Field xiayu = userPoClass.getDeclaredField("xuhongyu");
        xiayu.setAccessible(true);
        String name1 = xiayu.getName();
        Object o1 = xiayu.get(String.class);


        Constructor<?> userPoClassConstructor = userPoClass.getConstructor(String.class, String.class);
        Object o = userPoClassConstructor.newInstance("xiayu", "boy");



    }
}
