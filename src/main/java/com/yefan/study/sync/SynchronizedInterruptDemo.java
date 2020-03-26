package com.yefan.study.sync;

/**
 * synchronized 不能
 */
public class SynchronizedInterruptDemo {
    private static String lockObj = new String("i am lock");

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lockObj) {
                System.out.println(Thread.currentThread().getName() + "获取到锁！");
                System.out.println("always hold this lock");
                while (true){

                }
            }
        });

        Thread thread2= new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "阻塞，尝试获取锁");
            synchronized (lockObj) {
                System.out.println(Thread.currentThread().getName() + "获取到锁！");
            }
            System.out.println(Thread.currentThread().getName() + "结束");
        });

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(3000L);
            System.out.println("尝试中断");
            thread2.interrupt();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
