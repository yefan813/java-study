package com.yefan.study.thread;


/**
 * thread.sleep 不会释放对象锁
 */
public class ThreadSleepMethodDemo {


    private static TestDemo lockTarget;

    public static void main(String[] args) {
        lockTarget = new TestDemo(10);

        Thread thread1 = new Thread(new MyThread(2000L));

        Thread thread2 = new Thread(new MyThread(1000L));

        thread1.start();
        thread2.start();
    }

    private static class MyThread implements Runnable {
        private long sleep;

        public MyThread(long sleep) {
            this.sleep = sleep;
        }

        public void run() {
            synchronized (lockTarget) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程 id：" + Thread.currentThread().getId() + "获取到对象锁");
            }
        }
    }

    private static class TestDemo {
        private int num;

        public int getNum() {
            return num;
        }

        public TestDemo(int num) {
            this.num = num;
        }
    }
}
