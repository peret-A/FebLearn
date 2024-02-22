package com.bdqn.test05;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Restaurant {
/**
 * @author liuziyang
 * @data 2024-02-22-18:58
 */

public static void enroll(ArrayList<User> userArrayList){
    //创建User类
    User user = new User();
    //创建Scanner类
    Scanner scanner =new Scanner(System.in);
    System.out.print("输入用户名: ");
    user.setRoot(scanner.next());
    //用户名唯一
    for(User userList:userArrayList){
        //如果用户名相同就结束
        if(user.getName().equals(userList.getName()))
            return;
    }
    System.out.print("输入密码: ");
    user.setPwd(scanner.next());
    System.out.print("输入用户名称: ");
    user.setName(scanner.next());
    System.out.print("输入地址: ");
    user.setAdder(scanner.next());
    userArrayList.add(user);
}

    public static void login(ArrayList<User> userArrayList, ArrayList<Meal> mealArrayList, ArrayList<Order> orderArrayList) {
    //输入用户名 密码
    // 创建Scanner对象
    Scanner scanner =new Scanner(System.in);
    String root =scanner.next();
    String pwd = scanner.next();
    //创建User类
    User user=null;
    for(User userList:userArrayList){
        if(userList.getName().equals(root)&&userList.getPwd().equals(pwd)){
            user=userList;
        }
    }
    if(user==null){
        //user是空就说明 登录失败
        System.out.println("登录失败,用户名或者密码错误");
    }
    int input;
    do {
        RestaurantMean.submenu();
        System.out.print("请输入你的选择: ");
        input=scanner.nextInt();
        switch (input){
            case 0:
                return;
            case 1:orderFoot(user,mealArrayList,orderArrayList);
                    break;
            case 2:check(orderArrayList);
            break;
            case 3:sign(orderArrayList);
            break;
            case 4:dele(orderArrayList);
            break;
            case 5:like(mealArrayList);
            break;
            default:
                System.out.println("选择错误，重新选择");
                break;

        }
    }while (input!=0);
    }

    private static void like(ArrayList<Meal> mealArrayList) {
        //创建Scanner对象
        Scanner scanner =new Scanner(System.in);
        RestaurantMean.mealMean(mealArrayList);
        int id;
        while (true){
            System.out.print("请输入要点赞的序号: ");
            id =scanner.nextInt();
            if(id>0&&id<=mealArrayList.size()){
                break;
            }
        }
        mealArrayList.get(id-1).setLikes(mealArrayList.get(id-1).getLikes()+1);
    }

    private static void dele(ArrayList<Order> orderArrayList) {
        //创建Scanner对象
        Scanner scanner =new Scanner(System.in);
        check(orderArrayList);
        int id;
        while (true){
            System.out.print("请输入订单的序号: ");
            id =scanner.nextInt();
            if(id>0&&id<=orderArrayList.size()){
                break;
            }
        }
        orderArrayList.remove(id-1);
    }

    private static void sign(ArrayList<Order> orderArrayList) {
    //创建Scanner对象
        Scanner scanner =new Scanner(System.in);
        check(orderArrayList);
        int id;
        while (true){
            System.out.print("请输入订单的序号: ");
            id =scanner.nextInt();
            if(id>0&&id<=orderArrayList.size()){
                break;
            }
        }
        orderArrayList.get(id-1).setState("已完成");
    }

    public static void orderFoot(User user, ArrayList<Meal> mealArrayList, ArrayList<Order> orderArrayList){
    //创建Scanner对象
        Scanner scanner =new Scanner(System.in);
        RestaurantMean.mealMean(mealArrayList);
        int id;
        while (true){
            System.out.print("请输入要订餐的序号: ");
            id =scanner.nextInt();
            if(id>0&&id<=mealArrayList.size()){
                break;
            }
        }
        //创建Order类
        Order order =new Order();
        order.setId(orderArrayList.size()+1);
        order.setUname(user.getName());
        System.out.print("请输入要订餐的份数: ");
        order.setNum(scanner.nextInt());
        order.setMname(mealArrayList.get(id-1).getName());
        order.setMoney(mealArrayList.get(id-1).getPrice()*order.getNum());
        order.setState("已预定");
        DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        order.setTime(dateFormat.getCalendar().getTime());
        orderArrayList.add(order);
    }
    public static void check(ArrayList<Order> orderArrayList){
    for(Order order:orderArrayList){
        System.out.println(order);
    }

    }
}
