package com.yefan.study.thread;

public class ThreadIdTest {

    public static void main(String[] args) {

        method1111();
        method22222();

    }
    private static void method22222() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    for (int j = 0; j < 1000; j++) {
                        if(j == 100) {
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(i);
                    }
                }
            }
        },"high-cpu1").start();
    }
    private static void method1111() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    for (int j = 0; j < 1000; j++) {
                        if(j == 100) {
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("aaa");
                    }
                }
            }
        },"high-cpu2").start();
    }
}
