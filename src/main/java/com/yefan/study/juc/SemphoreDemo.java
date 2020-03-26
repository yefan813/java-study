package com.yefan.study.juc;

import java.util.Date;
import java.util.concurrent.Semaphore;


/**
 * 控制资源同一时间允许被访问的个数
 */
public class SemphoreDemo {

    private static Semaphore semphore = new Semaphore(2);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        semphore.acquire();
                        System.out.println(Thread.currentThread().getName() + "" + new Date());
                        Thread.sleep(1000L);
                        semphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }
    }
}
