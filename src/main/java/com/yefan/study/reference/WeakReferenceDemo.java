package com.yefan.study.reference;

import java.lang.ref.WeakReference;

public class WeakReferenceDemo {

    public static void main(String[] args) {
        ThreadLocal<Object> threadLocal = new ThreadLocal<>();
        WeakReference<ThreadLocal> weakReference = new WeakReference<ThreadLocal>(threadLocal);

    }
}
