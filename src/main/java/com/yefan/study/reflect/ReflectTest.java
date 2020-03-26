package com.yefan.study.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {
    public static Car initByDefaultConstrutor() throws Throwable {

        //①通过类装载器获取Car类对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.yefan.blog.reflect.Car");

        //②获取类的默认构造器对象并通过它实例化Car
        Constructor constructor = clazz.getDeclaredConstructor((Class[]) null);
        Car car = (Car) constructor.newInstance();

        //③通过反射方法设置属性
        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car, "长城");

        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car, "黑色");

        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car, 200);

        return car;
    }

    public static void main(String[] args) throws Throwable {
        Car car = initByDefaultConstrutor();
        car.introduce();
    }
}
