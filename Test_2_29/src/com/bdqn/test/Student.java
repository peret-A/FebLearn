package com.bdqn.test;

public class Student {
/**
 * @author liuziyang
 * @data 2024-02-29-16:13
 */
private int tid;
private String name;
private int age;
private String gender;
private String phnoe;
private String identitycard;
private String address;

    @Override
    public String toString() {
        return "Student{" +
                "tid=" + tid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", identitycard='" + identitycard + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdentitycard() {
        return identitycard;
    }

    public void setIdentitycard(String identitycard) {
        this.identitycard = identitycard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student() {
    }

    public String getPhnoe() {
        return phnoe;
    }

    public void setPhnoe(String phnoe) {
        this.phnoe = phnoe;
    }

    public Student(int tid, String name, int age, String gender, String phnoe, String identitycard, String address) {
        this.tid = tid;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phnoe = phnoe;
        this.identitycard = identitycard;
        this.address = address;
    }
}
