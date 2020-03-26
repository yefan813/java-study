package com.yefan.study.juc;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 独占锁实现
 */
public class MyExclusiveSynchronizer extends AbstractQueuedSynchronizer {
    @Override
    protected boolean tryAcquire(int arg) {
        if(compareAndSetState(0,1)){
            //设置当前线程独占锁
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    @Override
    protected boolean tryRelease(int arg) {
        //重置 state
        setState(0);
        //重置独占 owner 线程
        setExclusiveOwnerThread(null);
        return true;
    }

    public void lock() {
        //尝试加锁
        acquire(1);
    }

    public void unlock() {
        //解锁
        release(1);
    }

    public static void main(String[] args) {
        final MyExclusiveSynchronizer myExclusiveSynchronizer = new MyExclusiveSynchronizer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                myExclusiveSynchronizer.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " run");
                    System.out.println(Thread.currentThread().getName() + " will sleep 5 secs");
                    try {
                        Thread.sleep(5000l);
                        System.out.println(Thread.currentThread().getName() + " continue");
                    } catch (InterruptedException e) {
                        System.err.println(Thread.currentThread().getName() + " interrupted");
                        Thread.currentThread().interrupt();
                    }
                } finally {
                    myExclusiveSynchronizer.unlock();
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                myExclusiveSynchronizer.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " run");
                } finally {
                    myExclusiveSynchronizer.unlock();
                }
            }
        }).start();
    }
}
