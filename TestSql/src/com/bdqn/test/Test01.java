package com.bdqn.test;

import java.sql.*;

public class Test01 {
/**
 * @author liuziyang
 * @data 2024-02-26-14:42
 */
public static void main(String[] args) throws ClassNotFoundException, SQLException {
//1.注册驱动
//    Class.forName("com.mysql.jdbc.Driver");
    //2.获取链接
    String url="jdbc:mysql://127.0.0.1:3306/db_mylearn";
    String username="root";
    String password="123456";
    Connection connection = DriverManager.getConnection(url,username,password);
    //3.定义sql语句
    String sql ="select * from student";
//    String sql ="insert into student values(2,'张三',18,'2-311')";
//    String sql = "update student set age=13";
    //获取sql对象的statement
    Statement statement =connection.createStatement();
    //执行sql语句
//    int count =statement.executeUpdate(sql);
    ResultSet resultSet =statement.executeQuery(sql);
    //6.处理结果
//    System.out.println(count);
    while(resultSet.next()){
        System.out.println(resultSet.getInt(1));
        System.out.println(resultSet.getString(2));
        System.out.println(resultSet.getInt(3));
        System.out.println(resultSet.getString(4));
        System.out.println("-----------------");
    }

    //7.释放资源
    resultSet.close();
    statement.close();
    connection.close();
}
}
