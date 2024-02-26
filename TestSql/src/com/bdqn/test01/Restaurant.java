package com.bdqn.test01;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {
/**
 * @author liuziyang
 * @data 2024-02-26-19:34
 */
//用于作为 登录 注册
public static void login() throws SQLException {
    User user =new User();
    if((user =Mean.verify())==null){
        System.out.println("用户名或者密码错误");
        return;
    }
    int input;
    do {
        Scanner scanner =new Scanner(System.in);
        //进入子菜单
        Mean.submenu();
        System.out.print("请输入你的选择: ");
        input=scanner.nextInt();
        switch (input){
            case 0:
                return;
            case 1:Mean.orderFoot(user); //订餐
                break;
            case 2:Mean.check();//查看订单
                break;
            case 3:Mean.sign();//签收订单
                break;
            case 4:Mean.dele();//删除订单
                break;
            case 5:Mean.like();//点赞餐品
                break;
            default:
                System.out.println("选择错误，重新选择");
                break;

        }
    }while (input!=0);


}

public static void enroll() throws SQLException {
        //先从数据库读取全部数据
        // 与先注册的用户名比较 用户名唯一
        //1.注册驱动 并获取connection链接
        String url="jdbc:mysql:///db_mylearn";
        String root="root";
        String pwd="123456";
        Connection conn = DriverManager.getConnection(url,root,pwd);
        //2.定义sql
        String sql = "select root from user";

        //3.执行sql
        Statement sta = conn.createStatement();
        //获取结果集
        ResultSet result = sta.executeQuery(sql);
        ArrayList<String> arrayList = new ArrayList<>();
        while (result.next()){
            String s =result.getString(1);
            arrayList.add(s);
        }
        //创建Scanner对象
        Scanner scanner =new Scanner(System.in);
        System.out.print("输入要注册的用户名: ");
        String name = scanner.next();
        for(String x:arrayList){
            if(x.equals(name)){
                System.out.println("该用户名已存在!");
                return;
            }
        }
        User user =new User();
        user.setId(arrayList.size()+1);
        user.setRoot(name);
        System.out.print("输入要注册的密码: ");
        user.setPwd(scanner.next());
        System.out.print("输入要注册的名称: ");
        user.setUname(scanner.next());
        System.out.print("输入要注册的性别: ");
        user.setGender(scanner.next());
        System.out.print("输入要注册的年龄: ");
        user.setAge(scanner.nextInt());
        System.out.print("输入要注册的地址: ");
        user.setAddress(scanner.next());

        String sql1 ="insert into user values ("+user.getId()+",'"+user.getRoot()+"','"+user.getPwd()+"','"+user.getUname() +"','"+user.getGender()+"',"+user.getAge()+",'"+user.getAddress()+"') ";
        sta.executeUpdate(sql1);
        //释放资源
        result.close();
        sta.close();
        conn.close();
    }

}
