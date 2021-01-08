package com.xiayu.springboot_demo.annotation;

import com.xiayu.springboot_demo.domain.UserPo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author xuhongyu
 * @describe 注解Aop启动
 * @create 2021-01-06-10:59
 */
@Aspect
@Component
public class AnnotationAop {

    //AOP扫描的路径  并且在有注解AnnotationTest的时候进行处理
    @Pointcut(value = "execution(* com.xiayu.springboot_demo.*.*.*(..)) && @annotation(com.xiayu.springboot_demo.annotation.AnnotationTest)")
    public void addAdvice() {
    }

    //环绕模式
    @Around("addAdvice()")
    public Object Interceptor(ProceedingJoinPoint pjp) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //获取 切面类
        Class clazz = pjp.getTarget().getClass();
        //获取 切面类的所有方法
        Method[] methods = clazz.getDeclaredMethods();
        Object o1 = null;
        // 遍历所有方法
        for (Method method : methods) {
            //当方法有注解的时候
            if (method.isAnnotationPresent(AnnotationTest.class)) {
                //获取注解定义
                AnnotationTest cancelApiAnnotation = method.getAnnotation(AnnotationTest.class);
                //获取注解定义的值
                String value = cancelApiAnnotation.value();

                //获取返回值类型的名字
                String className = method.getReturnType().getName();
                //反射生成实例
                Class theClass = Class.forName(className);
                o1 = theClass.newInstance();
                //开始处理返回对象
                //获取返回对象的一个方法
                Method setMethod = o1.getClass().getMethod("setId", String.class);
                //为返回对象的
                setMethod.invoke(o1, value);
                break;
            }
        }
        return o1;
    }

}
