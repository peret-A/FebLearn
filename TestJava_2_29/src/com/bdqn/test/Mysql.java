package com.bdqn.test;

import java.sql.*;

public class Mysql {
/**
 * @author liuziyang
 * @data 2024-02-29-10:40
 */
public static void dml(String database,String sql){
    String url ="jdbc:mysql:///"+database;
    String user ="root";
    String password ="123456";
    Connection conn=null;
    Statement sta = null;
    try {
        //注册驱动，获取链接对象
        conn = DriverManager.getConnection(url,user,password);

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

public static void dql(String database,String sql) {
    //    Class.forName("com.mysql.jdbc.Driver");
    //注册驱动，获取链接
    String url = "jdbc:mysql:///" + database;
    String root = "root";
    String pwd = "123456";
    Connection conn = null;
    Statement sta = null;
    ResultSet set = null;
    try {
        conn = DriverManager.getConnection(url, root, pwd);
        //获取statement对象 发送sql
        sta = conn.createStatement();
        //执行sql
        set = sta.executeQuery(sql);

        ResultSetMetaData resultSetMetaData=set.getMetaData();
        //获取列数
        int size = resultSetMetaData.getColumnCount();
        for(int i=1;i<=size;i++){
            //获取指定列的名称。
            System.out.print("\t"+resultSetMetaData.getColumnName(i)+"\t");
        }
        System.out.println();
        while (set.next()){
            for(int i=1;i<=size;i++){
                if(resultSetMetaData.getColumnTypeName(i).equals("INT")||
                        resultSetMetaData.getColumnTypeName(i).equals("TINYINT")||
                        resultSetMetaData.getColumnTypeName(i).equals("BIGINT")){
                    System.out.print("\t"+set.getInt(i)+"\t");
                }
                if(resultSetMetaData.getColumnTypeName(i).equals("VARCHAR")){
                    System.out.print("\t"+set.getString(i)+"\t");
                }
                if(resultSetMetaData.getColumnTypeName(i).equals("FLOAT")){
                    System.out.print("\t"+set.getFloat(i)+"\t");
                }
                if(resultSetMetaData.getColumnTypeName(i).equals("DOUBLE")){
                    System.out.print("\t"+set.getDouble(i)+"\t");
                }
                if(resultSetMetaData.getColumnTypeName(i).equals("DATETIME")){
                    System.out.print("\t"+set.getDate(i)+"\t");
                }
            }
            System.out.println();
        }

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }finally {
        if(set!=null){
            try {
                set.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
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
