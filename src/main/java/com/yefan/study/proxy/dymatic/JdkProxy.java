package com.yefan.study.proxy.dymatic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkProxy implements InvocationHandler {
    Object target;

    public JdkProxy(Object target) {
        this.target = target;
    }

    /**
     * ，
     * @param proxy 代理对象
     * @param method 要执行代理对象的方法
     * @param args 方法参数
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before doing sth");
        Object result = method.invoke(target, args);
        System.out.println("after doing sth");
        return result;
    }

}
