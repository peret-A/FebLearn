package com.bdqn.test04;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test01 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        /*
        1)创建Mytxt类，创建myCreate()方法完成创建文件D:\myhello.txt文件的功能。
        创建带main方法的NewInstanceTest类，通过Class类获取Mytxt对象，调用myCreat()
         */
        //获取class类
        Class mytxtClass =Mytxt.class;
        //创建Mytxt类
        Mytxt mytxt =new Mytxt();
        //获取Mytxt类的方法
        //调用getDeclaredMethod（）方法 是因为避免myCreate方法是private无法获取
        Method method =mytxtClass.getDeclaredMethod("myCreate");
        //判断是否为private
        if(method.getModifiers()== Modifier.PRIVATE){
            //暴力破解
            method.setAccessible(true);
        }
        method.invoke(mytxt);
    }
}
