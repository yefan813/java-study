package com.yefan.study.generic;

public class GenericMethod {
    /**
     * 泛型方法
     * @param a
     * @param <T>
     * @return
     */
    public static <T> T getMiddle(T... a) {
        return a[a.length/2];
    }
}
