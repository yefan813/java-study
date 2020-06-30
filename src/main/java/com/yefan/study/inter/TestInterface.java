package com.yefan.study.inter;

/**
 * 类可以实现自多个几口但是只能继承自一个类
 */
public class TestInterface implements TestInterfaceOne, TestInterfaceTwo {


    @Override
    public int getNum() {
        return 0;
    }

    @Override
    public int getNum2() {
        return 0;
    }
}

interface  TestInterfaceOne {
    static int aa = 1;

    final int bb = 2;

    int cc = 3;

    int getNum();

    /**
     * 测试接口方法实现
     * @return
     */
    default int getTwo() {
        return 1;
    }
}


interface  TestInterfaceTwo {
    int getNum2();
}

/**
 * 接口一继承多个接口
 */
interface TestInterfaceThree extends TestInterfaceOne, TestInterfaceTwo {

}

