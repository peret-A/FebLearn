package com.bdqn.test01;

public class Meal {
/**
 * @author liuziyang
 * @data 2024-02-26-19:24
 */
private int id;
private String mname;
private double price;
private int likes;

    @Override
    public String toString() {
        return "菜品{" +
                "序号=" + id +
                ", 菜名='" + mname + '\'' +
                ", 价格=" + price +
                ", 点赞数=" + likes +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Meal() {
    }

    public Meal(int id, String mname, double price, int likes) {
        this.id = id;
        this.mname = mname;
        this.price = price;
        this.likes = likes;
    }
}
