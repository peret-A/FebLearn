package com.bdqn.test01;

import com.bdqn.entity.Person;

import java.lang.reflect.Field;

public class Test04 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //获取Class类
        Class personClass =Person.class;
        //获取Person类
        Person person =new Person();
        //获取person的字段
        Field[] personClassDeclaredFields=personClass.getDeclaredFields();
//        //遍历字段
//        for(Field field:personClassDeclaredFields){
//            System.out.println("字段修饰符: "+field.getModifiers());
//            System.out.println("字段类型: " + field.getType());
//            System.out.println("字段名称: " +field.getName());
//        }
        System.out.println(person);
        //获取name字段
        Field name=personClass.getDeclaredField("name");
        name.set(person,"小明");
        System.out.println(name.get(person));
//        获取age字段
        Field age=personClass.getDeclaredField("age");
//        age.set(person,11);
//        因为age是private的所以无法直接调用
//        应该先破解
        age.setAccessible(true);
        age.set(person,11);
        System.out.println(age.get(person));
    }
}
