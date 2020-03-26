package com.yefan.study;

public class StaticClassStudy {

    private NoneInnerStaticClass noneInnerStaticClass;

    public static class InnerStaticClass {
        public void sayHello() {
            System.out.println("hello, I am a Inner");
        }
    }

    public StaticClassStudy() {
        this.noneInnerStaticClass = new NoneInnerStaticClass();
    }

    public void sayHello() {
        noneInnerStaticClass.sayHello();
    }

    private class NoneInnerStaticClass {
        public void sayHello() {
            System.out.println("hello , I am a None Inner Class");
        }
    }
}
