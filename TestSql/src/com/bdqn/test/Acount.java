package com.bdqn.test;

public class Acount {
/**
 * @author liuziyang
 * @data 2024-02-26-16:14
 */
private int id;
private String  name;
private int age;
private String adder;

    @Override
    public String toString() {
        return "Acount{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", adder='" + adder + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdder() {
        return adder;
    }

    public void setAdder(String adder) {
        this.adder = adder;
    }

    public Acount() {
    }

    public Acount(int id, String name, int age, String adder) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.adder = adder;
    }
}
