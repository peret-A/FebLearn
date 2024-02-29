package com.bdqn.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class test04 {
/**
 * @author liuziyang
 * @data 2024-02-29-10:19
 */
public static void main(String[] args) {
    String url ="jdbc:mysql:///db_mylearn";
    String user ="root";
    String password ="123456";
    Connection conn=null;
    Statement sta = null;
    try {
        //注册驱动，获取链接对象
        conn = DriverManager.getConnection(url,user,password);
        //定义sql
        String sql = "delete from teacher where name = '张三'";
        //获取statement对象 发送sql
        sta = conn.createStatement();
        //执行sql
        int num = sta.executeUpdate(sql);
        //对结果处理
        System.out.println(num);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }finally {
        //释放资源
        if(sta!=null){
            try {
                sta.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
}
