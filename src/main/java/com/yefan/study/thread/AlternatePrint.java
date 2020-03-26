package com.yefan.study.thread;

/**
 * @author yefan
 * 交替打印
 *
 * wait 会释放同步获取到的对象锁
 * notify 不会释放对象获取到的锁
 * sleep 不会释放对象的锁
 */
public class AlternatePrint {
    private static int count = 0;

    private static  AlternatePrint lockTarget;
    public static void main(String[] args) {
        lockTarget = new AlternatePrint();
        new Thread(new MyThread1()).start();
        new Thread(new MyThread2()).start();
    }

    private static class MyThread1 implements Runnable {
        public void run() {
            synchronized (lockTarget) {
                while(true) {
                    System.out.printf("thread:%s,count:%s \n", Thread.currentThread().getId(), count ++);
                    try {
                        Thread.sleep(1000L);
                        System.out.printf("当前线程id:%s, 释放锁! 等待\n", Thread.currentThread().getId());
                        lockTarget.wait();
                        System.out.printf("当前线程id:%s, 重新获取对象锁，已经被唤醒\n", Thread.currentThread().getId());
                        lockTarget.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static class MyThread2 implements Runnable {
        public void run() {
            synchronized (lockTarget) {
                while(true) {
                    System.out.printf("thread:%s,count:%s \n", Thread.currentThread().getId(), count ++ );
                    lockTarget.notify();
                    try {
                        Thread.sleep(1000L);
                        System.out.printf("当前线程id:%s, 释放锁! 等待\n", Thread.currentThread().getId());
                        lockTarget.wait();
                        System.out.printf("当前线程id:%s, 重新获取对象锁，已经被唤醒\n", Thread.currentThread().getId());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


}
