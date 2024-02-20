package com.bdqn.entity;

public class Person {
    public String name;
    public String dept;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", age=" + age +
                '}';
    }

    public void fan(){
        System.out.println("1");
    }
    public void fan(String name){
        System.out.println("2");
    }
    private void fan(String name,int age){
        System.out.println("3");
    }

    public Person() {
        this.name = "小红";
        this.age = 22;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
