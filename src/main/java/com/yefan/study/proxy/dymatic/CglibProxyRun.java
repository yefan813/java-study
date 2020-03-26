package com.yefan.study.proxy.dymatic;

import net.sf.cglib.proxy.Enhancer;


/**
 * 查找目标类上的所有非final 的public类型的方法定义；
 * 将这些方法的定义转换成字节码；
 * 将组成的字节码转换成相应的代理的class对象；
 * 实现 MethodInterceptor接口，用来处理对代理类上所有方法的请求
 */
public class CglibProxyRun {

    public static void main(String[] args) {
        //创建方法拦截器 用于方法拦截调用
        LogInterceptor logInterceptor = new LogInterceptor();

        //创建一个增强器
        Enhancer enhancer = new Enhancer();
        //设置这个增强器父类
        enhancer.setSuperclass(UserDao.class);
        //设置回调类，当方法调用时拦截后执行拦截器的invoke方法
        enhancer.setCallback(logInterceptor);

        UserDao daoProxy = (UserDao) enhancer.create();
        daoProxy.select();
        daoProxy.update();

    }
}
