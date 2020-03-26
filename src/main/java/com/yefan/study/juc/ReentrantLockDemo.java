package com.yefan.study.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    private static ReentrantLock lock = new ReentrantLock(false);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        lock.lock();
                        if(true){
//                        if (lock.tryLock(500, TimeUnit.MILLISECONDS)){
                            System.out.println(Thread.currentThread().getName() + ",获取锁资源");
                            Thread.sleep(1000);
                            System.out.println(Thread.currentThread().getName() + ",休眠结束");
                        }else {
                            System.out.println(Thread.currentThread().getName() + "未获取到锁！执行其他逻辑");
                        }
                    } catch (InterruptedException e) {
                        System.out.println("异常了");
                    } finally {
                        if(lock.isHeldByCurrentThread()){
                            lock.unlock();
                        }
                    }
                }
            }).start();

            Thread daemonThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        System.out.println("queue count: " + lock.getQueueLength());
                        try {
                            Thread.sleep(100L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            daemonThread.setDaemon(true);
            daemonThread.start();
        }
    }
}
