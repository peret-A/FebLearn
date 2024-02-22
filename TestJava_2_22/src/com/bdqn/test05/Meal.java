package com.bdqn.test05;

public class Meal {
/**
 * @author liuziyang
 * @data 2024-02-22-18:36
 */
//餐的序号 餐的名称 餐的单价 餐的点赞数
    private int id;
    private String name;
    private double price;
    private int likes;

    @Override
    public String toString() {
        return "餐品{" +
                "序号=" + id +
                ", 名称='" + name + '\'' +
                ", 单价=" + price +
                ", 点赞数=" + likes +
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

    public Meal(int id, String name, double price, int likes) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.likes = likes;
    }
}
