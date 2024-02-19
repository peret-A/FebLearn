package com.bdqn.test02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Test02 {
    public static void main(String[] args) {
        /*
        题目二： 给定实体类Person，使用反射获取实体类的所有包，超类，构造方法，普通方法，属性信息。
         */
        //获取CLass类
        Class personClass =Person.class;
        //获取包
        Package packages = personClass.getPackage();
        System.out.println("Person的包名: "+packages.getName());
        //获取父类
        Class personClassSuperclass = personClass.getSuperclass();
        System.out.println("Person的父类: "+personClassSuperclass.getName());
        System.out.println("------------------------------------------------------------");
        //获取全部构造方法
        Constructor[] constructors =personClass.getDeclaredConstructors();
        for(Constructor constructor:constructors){
            //输出名称
            System.out.println("Person的构造方法: "+constructor.getName());
            //获取修饰符
            System.out.println("Person的构造方法的修饰符: "+(constructor.getModifiers() == 1 ? "public" : "private"));
            //获取参数列表
            Class[] types = constructor.getParameterTypes();
            for(Class type:types){
                System.out.println("Person的构造方法的参数类型: "+type.getName());
            }
        }
        System.out.println("------------------------------------------------------------");
        //获取普通方法
        Method[] personClassMethods =personClass.getMethods();
        for(Method method:personClassMethods){
            //输出名称
            System.out.println("Person的方法: "+method.getName());
            //获取修饰符
            System.out.println("Person的方法的修饰符: "+(method.getModifiers() == 1 ? "public" : "private"));
            //获取参数列表
            Class[] types = method.getParameterTypes();
            for(Class type:types){
                System.out.println("Person的构造方法的参数类型: "+type.getName());
            }
        }
    }
}
