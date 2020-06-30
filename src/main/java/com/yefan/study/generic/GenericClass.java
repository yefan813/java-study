package com.yefan.study.generic;

import com.yefan.study.entity.User;

/**
 * 泛型类
 * @author yefan
 * @param <T>
 */
public class GenericClass<T> {
    private T first;
    private T second;

    public GenericClass() {
    }

    public GenericClass(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public  T getFirst() {
        return this.first;
    }

    public static void main(String[] args) {
        GenericClass<User> genericClass = new GenericClass<>();
        User first = genericClass.getFirst();
    }
}
