package com.bdqn.test05;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {
/**
 * @author liuziyang
 * @data 2024-02-22-19:15
 */
public static void main(String[] args) {

        //创建Scanner对象
        Scanner scanner =new Scanner(System.in);
        //创建User类集合
    ArrayList<User> userArrayList =new ArrayList<>();

    //创建Meal类集合
    ArrayList<Meal> mealArrayList =new ArrayList<>();

    //创建Order类集合
    ArrayList<Order> orderArrayList =new ArrayList<>();
    //初始化菜单
    RestaurantMean.Init(mealArrayList);
        int input;
        do {
            RestaurantMean.mainMenu();
            System.out.print("输入你的选择: ");
            input =scanner.nextInt();
            switch (input){
                case 0:System.exit(0);
                    break;
                case 1:Restaurant.login(userArrayList,mealArrayList,orderArrayList);
                    break;
                case 2:Restaurant.enroll(userArrayList);
                    break;
                default:
                    System.out.println("选择错误,重新选择");
                    break;
            }
        }while (input!=0);
}
}
