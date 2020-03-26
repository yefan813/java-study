package com.yefan.study.sync;

public class SynchronizedStudy {

    public static void main(String[] args) {
        method1();
        method2();

        String str1 = "";
        synchronized(str1) {
            System.out.println(str1);
        }
    }

    private static synchronized void method1() {
        System.out.println("hello this is method 1");
    }

    private static void method2() {
        System.out.println("this is method2");
    }

    public synchronized void aa(){
        System.out.println(123);
    }
}