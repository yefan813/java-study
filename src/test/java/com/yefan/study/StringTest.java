package com.yefan.study;

import org.junit.Test;

public class StringTest {
    String lock = "lock";
    @Test
    public void test1() {

    }

    @Test
    public void test2() {

    }

    private void getLock(){
        synchronized (lock) {
            lock  += "123";
        }
        System.out.println(lock);
    }
}
