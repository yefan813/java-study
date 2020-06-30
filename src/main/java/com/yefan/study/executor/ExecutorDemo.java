package com.yefan.study.executor;

import java.util.concurrent.*;

public class ExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        test1();
    }

    private static void test() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(10);
        Executors.newScheduledThreadPool(10);
        Executors.newSingleThreadExecutor();
        Executors.newSingleThreadScheduledExecutor();

        //创建线程 可以帮助理解线程池的工作原理
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 15, 30,
                TimeUnit.HOURS, new ArrayBlockingQueue<>(10));

        threadPoolExecutor.execute(() -> System.out.println());
    }

    static class MyThreadFactory implements ThreadFactory {
        @Override
        public Thread newThread(Runnable r) {
            System.out.println("线程池新建了个线程！！！！");
            Thread t = new Thread(r);
            return t;
        }
    }

    private static void test1() throws InterruptedException {
        // java.util.concurrent.Executors.DefaultThreadFactory.DefaultThreadFactory 构造线程工厂
        ExecutorService executorService = new ThreadPoolExecutor(1,1,10,TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10),
                new MyThreadFactory());
        Runnable task = () -> System.out.println("hello world");
        executorService.execute(task);
        // 提交任务通过 DefaultThreadFactory.newThread() 创建线程
        TimeUnit.SECONDS.sleep(2);
        // 前一个工作线程在执行任务中抛出异常，再提交任务又会新建工作线程
        executorService.execute(task);

        TimeUnit.SECONDS.sleep(3);
    }
}
