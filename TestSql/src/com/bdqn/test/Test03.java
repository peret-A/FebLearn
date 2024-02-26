package com.bdqn.test;

import com.bdqn.test.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test03 {
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
    String sno="";
    String sname="";
    String sql ="select * from tb_student where sno=? and sname=?";

    //获取preparedStatement对象
    PreparedStatement prep = connection.prepareStatement(sql);

    //设置占位符的值
    prep.setString(1,"103");
    prep.setString(2,"陆君");

    //获取结果集
    ResultSet resultSet =prep.executeQuery();

    //创建结果集合
    List<Student> studentList =new ArrayList<>();
    while (resultSet.next()){
        String id = resultSet.getString(1);
        String name =resultSet.getString(2);
        String ssex = resultSet.getString(3);
        Date date =resultSet.getDate(4);
        String sclass = resultSet.getString(5);
        Student student =new Student(id,name,ssex,date,sclass);
        studentList.add(student);
    }

    //遍历
    for(Student student : studentList){
        System.out.println(student);
    }

    //结束资源
    resultSet.close();
    prep.close();
    connection.close();
}
}
