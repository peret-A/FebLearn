package com.bdqn.test;

import java.lang.reflect.InvocationTargetException;

public class test08 {
/**
 * @author liuziyang
 * @data 2024-02-29-11:41
 */
public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    String sql = "delete from teacher where name = '张三'";
    String datebase = "db_mylearn";
    Mysql.dml(datebase,sql);
}
}
