package com.yefan.study;


public class StudyTest {

    public static void main(String[] args) {
        StaticClassStudy study = new StaticClassStudy();
        study.sayHello();

        StaticClassStudy.InnerStaticClass innerStaticClass = new StaticClassStudy.InnerStaticClass();
        innerStaticClass.sayHello();

    }


}
