package com.bdqn.test01;

import java.lang.reflect.Method;

public class Test07 {
    public static void main(String[] args) {
        //获取class类
        Class personClass=Person.class;
        //获取全部方法
        Method[] personClassMethods =personClass.getMethods();
        //遍历方法
//        String getName()
//        以 String 形式返回此 Method 对象表示的方法名称。

    }
}
