package com.bdqn.test05;


import java.util.Date;

public class User {
/**
 * @author liuziyang
 * @data 2024-02-22-18:39
 */
//用户名 密码 用户名称 用户地点 用户时间
private String root;
private String pwd;
private String name;
private String adder;


    @Override
    public String toString() {
        return "用户{" +
                "用户名='" + root + '\'' +
                ", 密码='" + pwd + '\'' +
                ", 名称='" + name + '\'' +
                ", 地址='" + adder + '\'' +
                '}';
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdder() {
        return adder;
    }

    public void setAdder(String adder) {
        this.adder = adder;
    }


    public User() {
    }

    public User(String root, String pwd, String name, String adder) {
        this.root = root;
        this.pwd = pwd;
        this.name = name;
        this.adder = adder;

    }
}
