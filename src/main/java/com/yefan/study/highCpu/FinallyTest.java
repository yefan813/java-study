package com.yefan.study.highCpu;

public class FinallyTest {
    public static void main(String[] args) {
        try{
            System.out.println("aaaaaaaa");
            return;
        }finally {
            System.out.println("bbbbbbbb");
        }
    }
}
