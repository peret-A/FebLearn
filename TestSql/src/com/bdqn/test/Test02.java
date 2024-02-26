package com.bdqn.test;

import com.bdqn.test.Student;

import java.sql.*;
import java.util.ArrayList;

public class Test02 {
/**
 * @author liuziyang
 * @data 2024-02-26-16:15
 */
public static void main(String[] args) throws SQLException, ClassNotFoundException {
//    Class.forName("com.mysql.jdbc.Driver");
    //1.注册驱动 并获取链接
    String url="jdbc:mysql://127.0.0.1:3306/db_practices02";
    String username ="root";
    String password ="123456";
    Connection connection = DriverManager.getConnection(url,username,password);
    //2.定义sql语句
    String sql ="select * from tb_student";
    //3.执行sql语句
    Statement statement = connection.createStatement();
    //4.获取结果集
    ResultSet resultSet =statement.executeQuery(sql);
    //将数据存储在Student对象集合中
    ArrayList<Student> studentArrayList =new ArrayList<>();
    while (resultSet.next()){
        Student student =new Student(resultSet.getString("sno"),resultSet.getString("sname"),
                resultSet.getString("ssex"),resultSet.getDate("sbrithday"),
                resultSet.getString("class"));
        studentArrayList.add(student);
    }
    //遍历集合
    for(Student student : studentArrayList){
        System.out.println(student);
    }
    //结束资源
    resultSet.close();
    statement.close();
    connection.close();
}
}
