package com.bdqn.test01;

import java.lang.reflect.Constructor;

public class Test02 {
    public static void main(String[] args) throws NoSuchMethodException {
        //获取Class类
        Class personClass =Person.class;
        //获取Constructor类
        Constructor constructor =personClass.getConstructor();
        //获取无参构造方法的名称
        System.out.println("constructor.getName() = " + constructor.getName());
        //获取参数列表
        //	Class<?>[] getParameterTypes() 按照声明顺序返回一组 Class 对象，这些对象表示此 Constructor 对象所表示构造方法的形参类型。
        Class[] types =constructor.getParameterTypes();
        //遍历参数列表
        for(Class type:types){
            System.out.println("参数: " + type.getName());
        }
    }
}
