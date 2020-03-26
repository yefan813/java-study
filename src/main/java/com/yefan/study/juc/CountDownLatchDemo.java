package com.yefan.study.juc;


import java.util.Date;
import java.util.concurrent.CountDownLatch;


/**
 * CountDownLatch是一个计数器，它的构造方法中需要设置一个数值，用来设定计数的次数。每次调用countDown()方法之后，这个计数器都会减去1，
 * CountDownLatch会一直阻塞着调用await()方法的线程，直到计数器的值变为0。
 *
 *  执行完后不能重复使用，没办法重新设置 Count 的值
 *
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "" + new Date());
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        countDownLatch.countDown();
                    }
                }
            }).start();
        }

        try {
            countDownLatch.await();
            System.out.println("all Thread is Done!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
