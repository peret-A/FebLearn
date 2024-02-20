package com.bdqn.test01;

import com.bdqn.entity.Person;

import java.lang.reflect.Field;

public class Test03 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //获取CLass类
        Class personClass=Person.class;
        //创建Person
        Person person =new Person();
        //获取name字段
        Field name=personClass.getField("name");
        name.set(person,"小明");
        System.out.println(name.get(person));
        //获取age字段
//        Field age=personClass.getField("age"); 无法获取age字段
//        age.set(person,11);  因为age是private的所以无法直接调用
        //应该先破解
//        age.setAccessible(true);
//        age.set(person,11);
//        System.out.println(age.get(person));
    }
}
