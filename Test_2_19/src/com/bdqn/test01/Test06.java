package com.bdqn.test01;

public class Test06 {
    public static void main(String[] args) {
        //获取Class类
        Class personClass =Person.class;
        //Package getPackage()
        //          获取此类的包。
        Package personClassPackage =personClass.getPackage();
        System.out.println(personClassPackage.getName());
        //获取父类的
        Class superclass =personClass.getSuperclass();
        System.out.println(superclass.getName());
    }
}
