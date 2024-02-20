package com.bdqn.test02;

import com.bdqn.entity.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test01 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //获取Class类
        Class personClass=Person.class;
//        //获取所有公有方法 (包括父类方法)
//        Method[] personClassMethods=personClass.getMethods();
        //获取全部方法 (不包含父类方法)
//        Method[] personClassMethods = personClass.getDeclaredMethods();
//        //遍历
//        for(Method method:personClassMethods){
//            System.out.println("方法修饰符: " + method.getModifiers());
//            System.out.println("方法返回类型: " + method.getReturnType().getName());
//            System.out.println("方法名称: " + method.getName());
//            Class[] methodParameterTypes=method.getParameterTypes();
//            for(Class type: methodParameterTypes){
//                System.out.println("方法参数： " + type.getName());
//            }
//        }
        Person person = new Person();
//        //调用方法
//        Method method =personClass.getMethod("fan");
//        method.invoke(person);
//        //调用方法
//        Method method =personClass.getMethod("fan",String.class);
//        method.invoke(person,"1");
        //调用方法 无法调用私有方法
//        Method method =personClass.getMethod("fan",String.class,int.class);
        Method method=personClass.getDeclaredMethod("fan",String.class,int.class);
//        method.invoke(person,"1",2);
        //如果要使用私有方法就要先破解
        method.setAccessible(true);
        method.invoke(person,"1",2);
    }
}
