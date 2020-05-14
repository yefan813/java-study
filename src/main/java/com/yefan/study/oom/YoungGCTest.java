package com.yefan.study.oom;

/**
 * 设置启动参数
 * -XX:NewSize=5242880 -XX:MaxNewSize=5242880 -XX:InitialHeapSize=10485760 -XX:MaxHeapSize=10485760 -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=10485760 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc.log
 *
 */
public class YoungGCTest {

    public static void main(String[] args) {
        byte[] bytes = new byte[1024 * 1024];
        bytes = new byte[1024 * 1024];
        bytes = new byte[1024 * 1024];
        bytes = null;

        byte[] bytes1 = new byte[2 * 1024 * 1024];


    }
}
