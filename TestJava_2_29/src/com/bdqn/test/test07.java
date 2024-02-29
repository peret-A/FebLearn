package com.bdqn.test;

public class test07 {
/**
 * @author liuziyang
 * @data 2024-02-29-11:10
 */
public static void main(String[] args) {
    String sql = "update teacher set age=50 where name = '张三'";
    String database = "db_mylearn";
    Mysql.dml(database,sql);
}
}
