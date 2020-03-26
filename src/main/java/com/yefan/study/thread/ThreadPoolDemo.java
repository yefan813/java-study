package com.yefan.study.thread;

import java.util.concurrent.*;

public class ThreadPoolDemo {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 15, 2,
                TimeUnit.HOURS, new ArrayBlockingQueue<Runnable>(20));

        //注意传入的参数是实现了 Runnable 接口类的对象
        executor.execute(new MyThread());
    }

    static class MyThread implements Runnable {
        public void run() {

        }
    }
}
