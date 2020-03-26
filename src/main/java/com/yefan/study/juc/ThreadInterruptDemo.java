package com.yefan.study.juc;

public class ThreadInterruptDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                //sleep收到中断请求后 会把端标志位修改成 false
                Thread.sleep(5000L);
                System.out.println("线程中断能执行我吗？");
            } catch (InterruptedException e) {
                System.out.println("中断异常");
                System.out.println(Thread.currentThread().getName() + "isInterrupt:" + Thread.currentThread().isInterrupted());//此处一张为 false
            }
        });

        Thread thread1 = new Thread(() -> {
            while(true){
                Thread.yield();
                if(Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread().getName() + "收到中断请求，退出！");
                    return;
                }
            }
        });

        thread1.start();
        thread.start();


        try {
            Thread.sleep(2000L);
            thread.interrupt();
            thread1.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
