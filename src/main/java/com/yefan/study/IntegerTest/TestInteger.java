package com.yefan.study.IntegerTest;

import com.sun.org.apache.bcel.internal.generic.INEG;

public class TestInteger {
    public static void main(String[] args) {
        Integer i1 = new Integer(5);
        Integer i2 = 5;
        Integer i3 = 5;

        System.out.println(i1 == i2);
        System.out.println(i2 == i3);

    }
}
