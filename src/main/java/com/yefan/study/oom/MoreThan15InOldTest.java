package com.yefan.study.oom;

/**
 * 设置jvm 启动参数
 * -XX:NewSize=10485760 -XX:MaxNewSize=10485760 -XX:InitialHeapSize=20965760 -XX:MaxHeapSize=20965760
 * -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=10485760 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC
 * -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:gc1.log
 * 模拟年龄大于 15 岁进入老年代
 *
 */
public class MoreThan15InOldTest {
    public static void main(String[] args) {
        byte[] bytes1= new byte[64 * 1024];

        for (int i = 0; i < 16; i++) {
            byte[] bytes = new byte[7 * 1024 * 1024];
            bytes = null;
        }

    }
}
