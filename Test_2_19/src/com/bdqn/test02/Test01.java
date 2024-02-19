package com.bdqn.test02;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test01 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        /*
        题一： 给定实体类Person，使用反射给name属性、age属性赋值。
         */
        //获取Class类
        Class personClass=Person.class;
        //获取Consturct类
        Constructor personClassDeclaredConstructor =personClass.getDeclaredConstructor(String.class,int.class);
        //通过构造方法去实例化对象
        Person person =(Person)personClassDeclaredConstructor.newInstance("小鸟",25);
        System.out.println(person);
    }
}
