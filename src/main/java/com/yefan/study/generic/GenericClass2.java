package com.yefan.study.generic;

import java.util.UUID;

/**
 * 泛型类
 * @author yefan
 */
public class GenericClass2<T, U> {
    private U first;
    private T second;

    public GenericClass2(U first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getTObject() {
        return this.second;
    }

    public U getUObject() {
        return this.first;
    }
}
