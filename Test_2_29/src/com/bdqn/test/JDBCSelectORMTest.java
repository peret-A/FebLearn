package com.bdqn.test;

import java.sql.*;

public class JDBCSelectORMTest {
/**
 * @author liuziyang
 * @data 2024-02-29-18:57
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
        //创建Student对象
        Student student =new Student(1004,"赵六",32,"女","12345678912","340825200212241939","安徽合肥庐阳区");

        //定义sql
        String sql = "select * from student where tid = "+student.getTid()+"";

        //执行sql
        ResultSet resultSet = statement.executeQuery(sql);
        //对结果进行处理
        while (resultSet.next()){
            ResultSetMetaData resultSetMetaData =resultSet.getMetaData();
            //获取结果集的列数
            int size = resultSetMetaData.getColumnCount();
            StringBuilder stringBuilder =new StringBuilder();
            for(int i=1;i<=size;i++){
                if(resultSetMetaData.getColumnTypeName(i).equals("INT")){
                    if(i==size){
                        stringBuilder.append(resultSet.getInt(i));
                    }
                    else{
                        stringBuilder.append(resultSet.getInt(i)+"-");
                    }
                }
                if(resultSetMetaData.getColumnTypeName(i).equals("VARCHAR")){
                    if(i==size){
                        stringBuilder.append(resultSet.getString(i));
                    }else{
                        stringBuilder.append(resultSet.getString(i)+"-");
                    }
                }
            }
            System.out.println(stringBuilder);
        }
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
