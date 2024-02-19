package com.bdqn.test01;

import java.lang.reflect.Constructor;
import java.util.Collection;

public class Test04 {
    public static void main(String[] args) {
        //获取CLass类
        Class personClass =Person.class;
        //获取全部构造方法
        Constructor[] personClassDeclaredConstructors =personClass.getDeclaredConstructors();
        //遍历构造方法
        for(Constructor constructor:personClassDeclaredConstructors){
            System.out.println("构造方法名称: " + constructor.getName());
            //获取参数列表
            Class[] types =constructor.getParameterTypes();
            for(Class type:types){
                //输出参数列表
                System.out.println("参数: "+type.getName());
            }
            //获取构造方法修饰符
            int num = constructor.getModifiers();
            System.out.println("构造方法修饰符: " + (num == 1 ? "public" : "private"));
            System.out.println("--------");
        }

    }
}
