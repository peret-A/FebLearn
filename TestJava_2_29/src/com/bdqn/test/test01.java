package com.bdqn.test;

import java.sql.*;

public class test01 {
/**
 * @author liuziyang
 * @data 2024-02-29-9:21
 */
public static void main(String[] args) throws SQLException {
//    Class.forName("com.mysql.jdbc.Driver");
    //注册驱动，获取链接
    String url = "jdbc:mysql:///db_mylearn";
    String root = "root";
    String pwd = "123456";
    Connection conn = DriverManager.getConnection(url,root,pwd);
    //定义sql
    String sql ="select * from teacher";
    //执行sql
    Statement sta = conn.createStatement();
    ResultSet set = sta.executeQuery(sql);
    ResultSetMetaData resultSetMetaData=set.getMetaData();
    //获取列数
    int size = resultSetMetaData.getColumnCount();
    for(int i=1;i<=size;i++){
        //String getColumnClassName(int column)
        //如果调用方法 ResultSet.getObject 从列中获取值，则返回构造其实例的 Java 类的完全限定名称。
        //System.out.println(resultSetMetaData.getColumnTypeName(i));
        //String getColumnName(int column)
        //获取指定列的名称。
        System.out.print("\t"+resultSetMetaData.getColumnName(i));
    }
    System.out.println();
    while (set.next()){
        for(int i=1;i<=size;i++){
            if(resultSetMetaData.getColumnTypeName(i).equals("INT")||
                    resultSetMetaData.getColumnTypeName(i).equals("TINYINT")||
                    resultSetMetaData.getColumnTypeName(i).equals("BIGINT")){
                System.out.print("\t"+set.getInt(i));
            }
            if(resultSetMetaData.getColumnTypeName(i).equals("VARCHAR")){
                System.out.print("\t"+set.getString(i));
            }
            if(resultSetMetaData.getColumnTypeName(i).equals("FLOAT")){
                System.out.print("\t"+set.getFloat(i));
            }
            if(resultSetMetaData.getColumnTypeName(i).equals("DOUBLE")){
                System.out.print("\t"+set.getDouble(i));
            }
            if(resultSetMetaData.getColumnTypeName(i).equals("DATETIME")){
                System.out.print("\t"+set.getDate(i));
            }
        }
        System.out.println();
    }
    set.close();
    sta.close();
    conn.close();
}
}

