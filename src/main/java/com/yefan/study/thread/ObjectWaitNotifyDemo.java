package com.yefan.study.thread;

public class ObjectWaitNotifyDemo {
    private static ObjectWaitNotifyDemo lockTarget;
    private static int count = 0;

    public static void main(String[] args) {
        lockTarget = new ObjectWaitNotifyDemo();
        new Thread(new MyThread1()).start();
        new Thread(new MyThread2()).start();
    }

    static class MyThread1 implements Runnable {

        public void run() {
            synchronized (lockTarget) {
                System.out.printf("当前线程id: %s ,count: %s; \n" , Thread.currentThread().getId() , count++);
                try {
                    System.out.printf("当前线程id:%s, 释放锁! 等待\n", Thread.currentThread().getId());
                    lockTarget.wait();
                    System.out.printf("当前线程id:%s, 重新获取对象锁，已经被唤醒\n", Thread.currentThread().getId());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    static class MyThread2 implements Runnable {

        public void run() {
            synchronized (lockTarget) {
                System.out.printf("当前线程id: %s ,count: %s; \n" , Thread.currentThread().getId() , count++);
                    lockTarget.notify();
                System.out.printf("当前线程id:%s, 释放锁! \n", Thread.currentThread().getId());
            }

        }
    }


}
