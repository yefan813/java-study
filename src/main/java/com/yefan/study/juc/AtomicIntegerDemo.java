package com.yefan.study.juc;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
    private static AtomicInteger atomicInteger = new AtomicInteger(10);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    System.out.println("atomicInteger : " + atomicInteger.incrementAndGet());
                }
            }).start();
        }

    }
}
