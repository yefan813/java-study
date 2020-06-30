package com.yefan.study.inter;

public class TestClass {
    private String name;

    public TestClass(String name) {
        this.name = name;
    }

    public int getA() {
        return 1;
    }

    public final int getA(String aa) {
        return 3;
    }

    public static void main(String[] args) {
        // this compile error
//        new TestClass();

        TestClass testClass = new TestClass("test");

    }
}
