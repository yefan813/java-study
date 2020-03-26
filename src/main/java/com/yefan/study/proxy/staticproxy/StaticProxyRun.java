package com.yefan.study.proxy.staticproxy;

import com.yefan.study.proxy.UserService;
import com.yefan.study.proxy.impl.UserServiceImpl;

public class StaticProxyRun {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        StaticProxy staticProxyDemo = new StaticProxy(userService);

        staticProxyDemo.select();
        staticProxyDemo.update();
    }
}
