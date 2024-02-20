package com.bdqn.test03;

public class Student {
    //1)创建Student类，类中有属性name和age并封装属性
    private String name;
    private int age;
    //2)重载Student的构造函数，一个是无参构造并，另一个是带两个参数的有参构造，要求在构造函数打印提示信息
    public Student() {
        System.out.println("无参函数！");
    }
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("有参函数！");
    }
}
