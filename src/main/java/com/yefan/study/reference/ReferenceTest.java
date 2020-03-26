package com.yefan.study.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class ReferenceTest {
    public static void main(String[] args) {
        Object counter = new Object();
        ReferenceQueue refQueue = new ReferenceQueue();
        PhantomReference<Object> p = new PhantomReference<Object>(counter,refQueue);
        counter = null;
        System.gc();

        try {
            Reference reference = refQueue.remove(1000L);
            if(reference != null){
                System.out.println("i am phantom reachable");
            }
        }catch (InterruptedException e){

        }

    }
}
