package com.bdqn.test01;

/***
 * @Autor:fan
 *
 */

public class Person {
    //公共成员
    public String name;
    public int age;
    //默认成员
    char sex;
    //私有成员
    private String dept;
    //保护成员
    protected String add;
    //构造方法
    public Person(){
        this.name="小明";
        this.age=12;
        this.sex='男';
        this.dept="计算机";
        this.add="3-211";
    }

    public Person(String name, int age, char sex, String add) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.add = add;
    }
    //私有构造方法
    private Person(String name, int age, char sex, String dept,String add){
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.dept = dept;
        this.add = add;
    }
    public void fan(String name){
    }

    private void fan(String name,int age){
    }

    public int fan(String name,int age,char sex){
        return 1;
    }


    @Override
    public String toString() {
        return "Person{" +
                "名字='" + name + '\'' +
                ", 年龄=" + age +
                ", 性别=" + sex +
                ", 专业='" + dept + '\'' +
                ", 地址='" + add + '\'' +
                '}';
    }
}
