package com.yefan.study.highCpu;

public class CpuHighUseTest {
    public static void main(String[] args) {

        new Thread(new MyThread()).start();

        new Thread(new MyThread()).start();

        new Thread(new MyThread()).start();

    }

    private static class MyThread implements Runnable {
        public void run() {
            while (true) {
                for (int i = 0; i < 10000; i++) {
                    System.out.println(1);
                }

            }
        }
    }
}