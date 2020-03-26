package com.yefan.study;

import org.junit.Test;

import java.util.HashMap;

public class IntegerTest {

    @Test
    public void test1() {
        Integer i1 = new Integer(5);
        Integer i2 = 5;
        Integer i3 = 5;

        System.out.println(i1 == i2);
        System.out.println(i2 == i3);
    }



    @Test
    public void test2() {
        Integer i2 = 128;
        Integer i3 = 128;
        System.out.println(i2 == i3);
    }

    @Test
    public void test3() {
        Integer i2 = -128;
        Integer i3 = -128;
        System.out.println(i2 == i3);
    }

    @Test
    public void test4() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println( 1 << 30);
    }

    @Test
    public void test5() {
        System.out.println("inter max value:" + Integer.MAX_VALUE);
        System.out.println("inter min value:" + Integer.MIN_VALUE);
        System.out.println("float max value:" + Float.MAX_VALUE);
        System.out.println("float min value:" + Float.MIN_VALUE);
        System.out.println("Double max value:" + Double.MAX_VALUE);
        System.out.println("Double min value:" + Double.MIN_VALUE);
    }

    @Test
    public void test6() {

    }




}
