package com.yefan.study.serializable;

import java.io.*;

/**
 * serializable class test
 */
public class TestClassSerializable{


    public static void main(String[] args) {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("object.txt"))){
            Person person = new Person("aa", 12);
            person.abc = 100;
            outputStream.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Person implements Serializable {
    private static final long serialVersionUID = 3430556957794397688L;
    private String name;
    private int age;
    public static int abc = 14;

    public Person(String name, int age) {
        System.out.println("i am a construct method");
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age + '\'' +
                ", abc=" + abc +
                '}';
    }
}
