package com.yefan.study.proxy.impl;

import com.yefan.study.proxy.UserService;

/**
 * @author yefan
 */
public class UserServiceImpl implements UserService {
    public void select() {
        System.out.println("this select method");
    }

    public void update() {
        System.out.println("this is update method");
    }
}
