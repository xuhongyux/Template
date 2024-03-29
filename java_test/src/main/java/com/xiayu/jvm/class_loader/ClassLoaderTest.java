package com.xiayu.jvm.class_loader;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author xuhongyu
 * @describe 类的加载机制
 * @create 2021-09-22-11:29 上午
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {

        ClassLoader myLoader = new ClassLoader() {

            @Override

            public Class<?> loadClass(String name) throws ClassNotFoundException {

                try {

                    String fileName = name.substring(name.lastIndexOf(".") + 1)+".class";

                    InputStream is = getClass().getResourceAsStream(fileName);

                    if (is == null) {

                        return super.loadClass(name);

                    }

                    byte[] b = new byte[is.available()];

                    is.read(b);

                    return defineClass(name, b, 0, b.length);

                } catch (IOException e) {

                    throw new ClassNotFoundException(name);

                }

            }

        };

        Object obj = myLoader.loadClass("com.xiayu.jvm.class_loader.ClassLoaderTest").newInstance();

        System.out.println(obj.getClass());

        System.out.println(obj instanceof ClassLoaderTest);

    }
}