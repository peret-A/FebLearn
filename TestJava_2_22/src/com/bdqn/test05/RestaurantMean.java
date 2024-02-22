package com.bdqn.test05;

import java.util.ArrayList;

public class RestaurantMean {
/**
 * @author liuziyang
 * @data 2024-02-22-19:07
 */
public static void mainMenu(){
    System.out.println(" 1. 登录 ");
    System.out.println(" 2. 注册 ");
    System.out.println(" 0. 退出 ");
}
public static void submenu(){
    System.out.println(" 1. 订餐 ");
    System.out.println(" 2. 查看订单 ");
    System.out.println(" 3. 签收订单 ");
    System.out.println(" 4. 删除订单 ");
    System.out.println(" 5. 点赞订单 ");
    System.out.println(" 0. 退出 ");
}
public static void mealMean(ArrayList<Meal> mealArrayList){
    System.out.println("---------- 菜单 -----------");
    int count =1;
    for(Meal meal:mealArrayList){
        System.out.println(" "+count+". "+meal.getName()+" ");
        count++;
    }
}

    public static void Init(ArrayList<Meal> mealArrayList){
        Meal meal1 = new Meal(1,"小炒",21,13);
        Meal meal2 = new Meal(2,"红肠",8,13);
        Meal meal3 = new Meal(3,"烤鸭",16,13);
        Meal meal4 = new Meal(4,"土豆",4,13);
        Meal meal5 = new Meal(5,"地三鲜",30,13);
        Meal meal6 = new Meal(6,"红茶",12,13);
        Meal meal7 = new Meal(7,"绿茶",12,13);
        Meal meal8 = new Meal(8,"啤酒",8,13);
        Meal meal9 = new Meal(9,"红酒",134,13);
        mealArrayList.add(meal1);
        mealArrayList.add(meal2);
        mealArrayList.add(meal3);
        mealArrayList.add(meal4);
        mealArrayList.add(meal5);
        mealArrayList.add(meal6);
        mealArrayList.add(meal7);
        mealArrayList.add(meal8);
        mealArrayList.add(meal9);


    }
}
