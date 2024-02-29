package com.bdqn.test;

import java.sql.*;

public class test05 {
/**
 * @author liuziyang
 * @data 2024-02-29-10:29
 */
//注册驱动，获取链接
public static void main(String[] args) throws SQLException {
    String url = "jdbc:mysql:///db_mylearn";
    String root = "root";
    String pwd = "123456";
    Connection conn = DriverManager.getConnection(url,root,pwd);
    //定义sql
    String sql ="select * from teacher";
    //执行sql
    Statement sta = conn.createStatement();
    ResultSet set = sta.executeQuery(sql);
    while (set.next()){
        set.deleteRow();
    }
    set.close();
    sta.close();
    conn.close();

}
}
