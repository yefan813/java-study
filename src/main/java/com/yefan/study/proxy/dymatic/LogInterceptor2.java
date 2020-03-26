package com.yefan.study.proxy.dymatic;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class LogInterceptor2 implements MethodInterceptor {

    /**
     *
     * @param o 被代理对象
     * @param method 被拦截的方法
     * @param args 参数列表
     * @param methodProxy
     * @return 表示对方法的代理，invokeSuper方法表示对被代理对象方法的调用
     * @throws Throwable
     */
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("before 222 doing sth");
        Object result = methodProxy.invokeSuper(o, args);
        System.out.println("after 222 doing sth");
        return result;
    }
}
