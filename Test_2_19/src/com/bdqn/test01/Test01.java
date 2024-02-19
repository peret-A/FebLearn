package com.bdqn.test01;

import java.lang.reflect.Constructor;

public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        //获取Class对象的方式：
        //方式1：使用Object类的getClass()方法
        Person person = new Person();
        Class personClass1 =person.getClass();
        System.out.println("personClass1.getName() = " + personClass1.getName());
//        Constructor<T> getConstructor(Class<?>... parameterTypes)
//        返回一个 Constructor 对象，它反映此 Class 对象所表示的类的指定公共构造方法。
        Constructor constructor =personClass1.getConstructor();
        //String getName() 以字符串形式返回此构造方法的名称。
        System.out.println("constructor.getName() = " + constructor.getName());


        //方式2：使用Object类的静态成员class
        Class personClass2 =Person.class;
        System.out.println("personClass2.getName() = " + personClass2.getName());


        //方式3：使用Class类的forName(String url)方法，用目标类的完整路径作为参数
        Class personClass3 =Class.forName("com.bdqn.test01.Person");
        System.out.println("personClass3.getName() = " + personClass3.getName());


    }
}
