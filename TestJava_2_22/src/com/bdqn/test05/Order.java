package com.bdqn.test05;

import java.util.Date;

public class Order {
/**
 * @author liuziyang
 * @data 2024-02-22-18:39
 */
//订单序号 订餐人名字 订单餐名 订餐份数 订餐状态 送餐时间 总金额
    private int id;
    private String Uname;
    private String Mname;
    private int num;
    private String state;
    private Date time;
    private double money;

    @Override
    public String toString() {
        return "订单{" +
                "序号=" + id +
                ", 订餐人='" + Uname + '\'' +
                ", 餐名='" + Mname + '\'' +
                ", 餐费='" + money + '\'' +
                ", 数量=" + num + '\'' +
                ", 状态='" + state + '\'' +
                ", 订餐时间=" + time +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public String getMname() {
        return Mname;
    }

    public void setMname(String mname) {
        Mname = mname;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Order() {
    }

    public Order(int id, String uname, String mname, int num, String state, Date time, double money) {
        this.id = id;
        Uname = uname;
        Mname = mname;
        this.num = num;
        this.state = state;
        this.time = time;
        this.money = money;
    }
}
