package com.yefan.study.juc;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockMultiThreadDemo {
    private static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        new Thread(()->{
            lock.lock();
            try {
                Thread.sleep(20000);
                System.out.println("thread2 is done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        },"thread2").start();

        new Thread(()->{
            lock.lock();
            try {
                Thread.sleep(20000);
                System.out.println("thread1 is done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        },"thread1").start();

        new Thread(()->{
            lock.lock();
            try {
                Thread.sleep(20000);
                System.out.println("thread3 is done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        },"thread3").start();


    }
}
