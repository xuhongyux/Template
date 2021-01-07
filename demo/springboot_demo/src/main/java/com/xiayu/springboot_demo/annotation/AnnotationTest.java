package com.xiayu.springboot_demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xuhongyu
 * @describe 注解
 * @create 2021-01-05-16:42
 */
//生命周期
@Retention(value = RetentionPolicy.RUNTIME)
//指定注解放置的地方.方法, 变量,类,
@Target({ElementType.METHOD})
public @interface AnnotationTest {
    String value() default "xiayu";
}
