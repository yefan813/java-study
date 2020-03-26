package com.yefan.study.proxy.staticproxy;

import com.yefan.study.proxy.UserService;

/**
 * 静态代理
 * 优点: 对代理的类无侵入
 * 缺点: 1 。当需要代理对个类时，
 * 2. 当代理的接口修改（增减或者修改方法）代理类都要跟着改动，不移维护
 * 3. 通一个代理类实现多个接口代理时，耦合太大，不易维护
 * 4，当一个代理类实现一个接口时 代理类过多
 *
 * 接下里就是动态代理出场的时间，解决了静态代理以上的缺点
 */
public class StaticProxy implements UserService {
    private UserService target;

    public StaticProxy(UserService target) {
        this.target = target;
    }

    public void select() {
        System.out.println("before doing sth");
        target.select();
        System.out.println("after doing sth");
    }

    public void update() {
        System.out.println("before doing sth");
        target.update();
        System.out.println("after doing sth");
    }
}
