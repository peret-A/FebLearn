package com.bdqn.test;

import java.sql.SQLException;

public class test06 {
/**
 * @author liuziyang
 * @data 2024-02-29-10:46
 */
public static void main(String[] args) throws SQLException {
    String sql = "select * from meal";
    String database ="db_mylearn";
    Mysql.dql(database,sql);



}
}
