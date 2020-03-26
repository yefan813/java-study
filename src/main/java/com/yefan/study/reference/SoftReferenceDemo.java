package com.yefan.study.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class SoftReferenceDemo {

    public static void main(String[] args) {
        ReferenceQueue referenceQueue = new ReferenceQueue<SoftReference<Object>>();
        SoftReference<Object> softReference = new SoftReference<Object>(new byte[4 * 1024 * 1024], referenceQueue);
        System.out.println(softReference.get());

        byte[] bytes = new byte[2 * 1024 * 1024];
        byte[] bytes1 = new byte[2 * 1024 * 1024];
        byte[] bytes2 = new byte[2 * 1024 * 1024];

        Reference poll = referenceQueue.poll();
        System.out.println(poll);

        System.out.println(softReference.get());


    }
}
