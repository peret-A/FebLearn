package com.bdqn.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDeleteTest {
/**
 * @author liuziyang
 * @data 2024-02-29-16:26
 */
public static void main(String[] args) {
    Connection connection=null;
    Statement statement=null;
    try {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //链接Connection
        connection = DriverManager.getConnection("jdbc:mysql:///db_practices02","root","123456");
        //获取Satement对象
        statement = connection.createStatement();
        //定义sql
        String sql = "delete from student where tid = 1002 ";

        //执行sql
        int num = statement.executeUpdate(sql);
        //对结果进行处理
        System.out.println(num==0?"删除失败":"删除成功");
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }finally {
        //资源释放
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
}
