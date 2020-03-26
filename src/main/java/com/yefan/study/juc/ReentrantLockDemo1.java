package com.yefan.study.juc;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo1 {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //通 synchronized 一样 竞争锁的线程无法中断即阻塞状态的线程无法中断
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "获取到锁");
                    if (Thread.currentThread().isInterrupted()) {
                        lock.unlock();
                        System.out.println(Thread.currentThread().getName() + "中断退出");
                        return;
                    }
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //通 synchronized 一样 竞争锁的线程无法中断即阻塞状态的线程无法中断
                    try {
                        lock.lockInterruptibly();
                        System.out.println(Thread.currentThread().getName() + "获取到锁============》");
                        if (Thread.currentThread().isInterrupted()) {
                            lock.unlock();
                            System.out.println(Thread.currentThread().getName() + "中断退出");
                            return;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });



        thread.start();
        thread1.start();
        //中断加锁
        thread1.interrupt();

        try {
            Thread.sleep(50L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

    }
}
