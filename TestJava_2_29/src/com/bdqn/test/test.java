package com.bdqn.test;

import java.sql.*;
import java.util.List;

public class test {
/**
 * @author liuziyang
 * @data 2024-02-29-9:10
 */
public static void main(String[] args) throws SQLException {
    //注册驱动，获取链接
    String url = "jdbc:mysql:///db_mylearn";
    String root = "root";
    String pwd = "123456";
    Connection conn = DriverManager.getConnection(url,root,pwd);
    //定义sql
    String sql ="select * from meal";
    //执行sql
    Statement sta = conn.createStatement();
    ResultSet set = sta.executeQuery(sql);
    while (set.next()){
        System.out.println(set.getString("mname"));
    }
    set.close();
    sta.close();
    conn.close();
}
}
