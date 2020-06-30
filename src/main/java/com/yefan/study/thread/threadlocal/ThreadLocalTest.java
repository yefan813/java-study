package com.yefan.study.thread.threadlocal;

public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocalDog threadLocalDog=new ThreadLocalDog();
        threadLocalDog.threadLocal.set("小黄");

        ThreadLocalDog threadLocalDog1 = new ThreadLocalDog();
        threadLocalDog1.threadLocal.set("小Green");

        System.out.println(threadLocalDog.threadLocal.get());
        System.out.println(threadLocalDog1.threadLocal.get());

        ThreadLocalDogStatic.threadLocal.set("小static");
        System.out.println(ThreadLocalDogStatic.threadLocal.get());
    }
}
