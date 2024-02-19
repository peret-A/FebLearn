package com.bdqn.test01;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test05 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取Class类
        Class personClass=Person.class;
        //获取Construct
            Constructor personClassConstructor =personClass.getConstructor(String.class,int.class,char.class,String.class);
        //构造方法实力化
        //T newInstance(Object... initargs)
        //				使用此 Constructor 对象表示的构造方法来创建该构造方法的声明类的新实例，并用指定的初始化参数初始化该实例。
        Person person =(Person)personClassConstructor.newInstance("小侯",24,'男',"2-311");
        System.out.println(person);
    }
}
