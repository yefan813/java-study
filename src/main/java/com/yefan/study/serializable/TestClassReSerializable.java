package com.yefan.study.serializable;

import java.io.*;

/**
 * fan serializable
 * @author yefan
 */
public class TestClassReSerializable {
    public static void main(String[] args) {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.txt"))){
            Person person = (Person) objectInputStream.readObject();
            System.out.println(person);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}



