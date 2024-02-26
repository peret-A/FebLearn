package com.bdqn.test01;

public class User {
/**
 * @author liuziyang
 * @data 2024-02-26-18:54
 */
private int id;
private String root;
private String pwd;
private String uname;
private String gender;
private int age;
private String address;

    @Override
    public String toString() {
        return "用户{" +
                "序号=" + id +
                ", 用户名='" + root + '\'' +
                ", 密码='" + pwd + '\'' +
                ", 名称='" + uname + '\'' +
                ", 性别='" + gender + '\'' +
                ", 年龄=" + age +
                ", 地址='" + address + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User() {
    }

    public User(int id, String root, String pwd, String uname, String gender, int age, String address) {
        this.id = id;
        this.root = root;
        this.pwd = pwd;
        this.uname = uname;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }
}
