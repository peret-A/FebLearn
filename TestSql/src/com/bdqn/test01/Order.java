package com.bdqn.test01;

public class Order {
/**
 * @author liuziyang
 * @data 2024-02-26-19:26
 */
private int id;
private String uname;
private String mname;
private double price;

private String state;

    @Override
    public String toString() {
        return "订单{" +
                "序号=" + id +
                ", 订餐人='" + uname + '\'' +
                ", 菜名='" + mname + '\'' +
                ", 价格=" + price +
                ", 状态.='" + state + '\'' +
                '}';
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Order(int id, String uname, String mname, double price, String state) {
        this.id = id;
        this.uname = uname;
        this.mname = mname;
        this.price = price;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Order() {
    }

    public Order(int id, String uname, String mname, double price) {
        this.id = id;
        this.uname = uname;
        this.mname = mname;
        this.price = price;
    }
}
