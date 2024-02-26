package com.bdqn.test01;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Mean {
/**
 * @author liuziyang
 * @data 2024-02-26-19:30
 */
//用于菜单


//用于存储 菜单 方法
public static void mainMenu(){
    System.out.println("---------- 主系统 -----------");
    System.out.println(" 1. 登录 ");
    System.out.println(" 2. 注册 ");
    System.out.println(" 0. 退出 ");
}

    public static void submenu(){
        System.out.println("---------- 子系统 -----------");
        System.out.println(" 1. 订餐 ");
        System.out.println(" 2. 查看订单 ");
        System.out.println(" 3. 签收订单 ");
        System.out.println(" 4. 删除订单 ");
        System.out.println(" 5. 点赞订单 ");
        System.out.println(" 0. 退出 ");
    }
    public static void orderFoot(User user) throws SQLException {
        System.out.println("---------- 订餐 -----------");
        //先从数据库读取全部数据
        //1.注册驱动 并获取connection链接
        String url="jdbc:mysql:///db_mylearn";
        String root="root";
        String pwd="123456";
        Connection conn = DriverManager.getConnection(url,root,pwd);
        //2.定义sql
        String sql = "select * from meal";

        //执行sql
        Statement sta = conn.createStatement();
        ResultSet set = sta.executeQuery(sql);

        ArrayList<Meal> mealArrayList = new ArrayList<>();
        while (set.next()){
            Meal meal =new Meal();
            meal.setId(set.getInt("id"));
            meal.setMname(set.getString("mname"));
            meal.setPrice(set.getDouble("price"));
            meal.setLikes(set.getInt("likes"));
            mealArrayList.add(meal);
        }
        //遍历
        for(Meal meal:mealArrayList){
            System.out.println(meal);
        }
        //创建scanner对象
        Scanner scanner =new Scanner(System.in);
        System.out.print("请输入要订餐的序号: ");
        int id=0;
        while (true){
            id= scanner.nextInt();
            if(id>0&&id<=mealArrayList.size()){
                break;
            }
        }

        //定义sql
        String sql1 ="insert into order values("+user.getId()
                +",'"+user.getRoot()+"','"+user.getPwd()+"','"+user.getUname()+"','"+user.getGender()
                +"',"+user.getAge()+",'"+user.getAddress()+"')";

        //执行sql
        sta.executeUpdate(sql1);
        //关闭资源
        set.close();
        sta.close();
        conn.close();

    }
    public static int check() throws SQLException {
        System.out.println("---------- 查看订单 -----------");
        String url="jdbc:mysql:///db_mylearn";
        String root="root";
        String pwd="123456";
        Connection conn = DriverManager.getConnection(url,root,pwd);
        //2.定义sql
        String sql = "select * from order";
        //执行sql
        Statement sta = conn.prepareStatement(sql);
        //获取结果集
        ResultSet res = sta.executeQuery(sql);
        ArrayList<Order> orderArrayList = new ArrayList<>();
        while (res.next()){
            Order order =new Order();
            order.setId(res.getInt("id"));
            order.setUname(res.getString("uname"));
            order.setMname(res.getString("mname"));
            order.setPrice(res.getDouble("price"));
            order.setState(res.getString("state"));
            orderArrayList.add(order);
        }
        //遍历数据
        for(Order order:orderArrayList){
            System.out.println(order);
        }
        return orderArrayList.size();
    }

    public static void dele(){

    }

    public static void sign() throws SQLException {
        int size = check();
        //创建scanner对象
        Scanner scanner =new Scanner(System.in);
        System.out.print("请输入要订餐的序号: ");
        int id=0;
        while (true){
            id= scanner.nextInt();
            if(id>0&&id<=size){
                break;
            }
        }

        String url="jdbc:mysql:///db_mylearn";
        String root="root";
        String pwd="123456";
        Connection conn = DriverManager.getConnection(url,root,pwd);
        //2.定义sql
        String sql = "update  order set state='已完成' where id ="+id+"";
        //执行sql
        Statement sta = conn.prepareStatement(sql);
        sta.executeUpdate(sql);
    }

    public static void like(){

    }

    public static User verify() throws SQLException {
        //先从数据库读取全部数据
        // 与先注册的用户名比较 用户名唯一
        //1.注册驱动 并获取connection链接
        String url="jdbc:mysql:///db_mylearn";
        String root="root";
        String pwd="123456";
        Connection conn = DriverManager.getConnection(url,root,pwd);
        //2.定义sql
        //创建Scanner对象
        Scanner scanner =new Scanner(System.in);
        System.out.print("输入要注册的用户名: ");
        String name = scanner.next();
        System.out.print("输入要注册的密码: ");
        String password = scanner.next();

        String sql = "select * from user where root=? and pwd=?";

        //3.执行sql
        PreparedStatement sta = conn.prepareStatement(sql);
        sta.setString(1,name);
        sta.setString(2,password);
        //获取结果集
        ResultSet result = sta.executeQuery();
        while (result.next()){
            User user =new User();
            user.setId(result.getInt("id"));
            user.setRoot(result.getString("root"));
            user.setPwd(result.getString("pwd"));
            user.setUname(result.getString("uname"));
            user.setGender(result.getString("gender"));
            user.setAge(result.getInt("age"));
            user.setAddress(result.getString("address"));
            return user;
        }
        return null;
    }
}


