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

        int size = size();
        //定义sql
        String sql1 ="insert into `order` values("+(size+1)
                +",'"+user.getUname()+"','"+mealArrayList.get(id-1).getMname()+"',"+
                mealArrayList.get(id-1).getPrice()+",'已预订')";
        //执行sql
        sta.executeUpdate(sql1);
//        关闭资源
        set.close();
        sta.close();
        conn.close();

    }
    public static void check() throws SQLException {
        System.out.println("---------- 查看订单 -----------");
        size();
        String url="jdbc:mysql:///db_mylearn";
        String root="root";
        String pwd="123456";
        Connection conn = DriverManager.getConnection(url,root,pwd);
        //2.定义sql
        String sql = "select * from `order`";
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
    }

    public static int size() throws SQLException {
        String url="jdbc:mysql:///db_mylearn";
        String root="root";
        String pwd="123456";
        Connection conn = DriverManager.getConnection(url,root,pwd);
        //2.定义sql
        String sql = "select * from `order`";
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
        for(int i=1;i<= orderArrayList.size();i++){
            //2.定义sql
            String sql1 = "update `order` set id = "+i+" where uname = '"+orderArrayList.get(i-1).getUname()+"'";
            sta.executeUpdate(sql1);
        }
        return orderArrayList.size();
    }
    public static void dele() throws SQLException {
        int size = size();
        check();
        //创建scanner对象
        Scanner scanner =new Scanner(System.in);
        int id=0;
        while (true){
            System.out.print("请输入要订餐的序号: ");
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
        String sql = "delete from `order` where id ="+id+"";
        //执行sql
        Statement sta = conn.prepareStatement(sql);
        sta.executeUpdate(sql);
    }

    public static void sign() throws SQLException {
        int size =size();
        check();
        //创建scanner对象
        Scanner scanner =new Scanner(System.in);
        int id=0;
        while (true){
            System.out.print("请输入要订餐的序号: ");
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
        String sql = "update  `order` set state='已完成' where id ="+id+"";
        //执行sql
        Statement sta = conn.prepareStatement(sql);
        sta.executeUpdate(sql);
    }

    public static void like() throws SQLException {
        int size =size();
        check();
        //创建scanner对象
        Scanner scanner =new Scanner(System.in);
        int id=0;
        while (true){
            System.out.print("请输入要订单的序号: ");
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
        String sql = "select mname from `order` where id ="+id+"";
        //执行sql
        Statement sta = conn.prepareStatement(sql);
        ResultSet resultSet = sta.executeQuery(sql);
        String mname = resultSet.getString("mname");
        String sql1 ="select likes from meal where mname = "+mname+"";
        ResultSet resultSet1 =sta.executeQuery(sql1);
        int likes =resultSet1.getInt("likes");
        String sql2 ="update `order` set likes = "+(likes+1)+"";
        sta.executeUpdate(sql2);
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


