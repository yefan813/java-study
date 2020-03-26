package com.yefan.study.juc;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *
 * 调用await()方法的时候，这个线程就会被阻塞，当调用await()
 * 的线程数量到达屏障数的时候，主线程就会取消所有被阻塞线程的状态。
 *
 * 在CyclicBarrier的构造方法中，还可以设置一个barrierAction。
 * 在所有的屏障都到达之后，会启动一个线程来运行这里面的代码。
 *
 * @author yefan
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        final Random random = new Random();
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            public void run() {
                System.out.println("大家都到齐就继续执行吧");
            }
        });
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                public void run() {
                    int step = random.nextInt(5);
                    System.out.println(Thread.currentThread().getName() + "" +
                            new Date() + ",sleep " + step + " seconds");
                    try {
                        Thread.sleep(step * 1000L);
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "" +
                            new Date() + "run over!");
                }
            }).start();
        }

    }
}
