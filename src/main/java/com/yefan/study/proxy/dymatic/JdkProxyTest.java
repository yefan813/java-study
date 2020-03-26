package com.yefan.study.proxy.dymatic;

import com.yefan.study.proxy.UserService;
import com.yefan.study.proxy.impl.UserServiceImpl;

import java.lang.reflect.Proxy;

/**
 * JDK 实现的动态代理需要继承 InvocationHandler 类， 使用Proxy.newProxyInstance实例化
 * 代理类
 * 注意 JDK proxy 要代理的对象必须是接口，
 * 因为自动生成的代理类继承自 Proxy，由于 java 单继承的限制，要代理对象，那么那个对象必须是借口类型
 */
public class JdkProxyTest {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        JdkProxy jdkProxy = new JdkProxy(userService);
        UserService proxyObject = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader()
                , userService.getClass().getInterfaces()
                , jdkProxy);

        proxyObject.select();
        proxyObject.update();
    }
}
