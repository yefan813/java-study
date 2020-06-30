package com.yefan.study.inter;

/**
 *
 * @author yefan
 * 1.接口的方法默认是 public，所有方法在接口中不能有实现(Java 8 开始接口方法可以有默认实现），而抽象类可以有非抽象的方法。
 * 2. 接口中除了 static、final 变量，不能有其他变量，而抽象类中则不一定。
 * 3.一个类可以实现多个接口，但只能实现一个抽象类。接口自己本身可以通过 extends 关键字扩展多个接口。
 * 4.接口方法默认修饰符是 public，抽象方法可以有 public、protected 和 default 这些修饰符（抽象方法就是为了被重写所以不能使用 private 关键字修饰！）。
 * 5.从设计层面来说，抽象是对类的抽象，是一种模板设计，而接口是对行为的抽象，是一种行为的规范。
 */
public class TestAbstract extends AbstractClassOne {
    @Override
    int getNum() {
        return 0;
    }
}

abstract class AbstractClassOne {
    abstract int getNum();

    int getAA() {
        return 123;
    }

    private int abc;

}

abstract class AbstractClassTwo {

}


