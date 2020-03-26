package com.yefan.study.reflect;

public class ClassLoaderTest {

    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println("current loader:" + loader);
        System.out.println("parent loader:" + loader.getParent());
        System.out.println("root loader:" + loader.getParent().getParent());
    }
}
