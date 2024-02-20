package com.bdqn.test05;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class test01 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        /*
    定义PrivateTest类，有私有name属性，并且属性值为hellokitty，只提供name的getName的公有方法
    创建带有main方法ReflectTest的类，利用Class类得到私有的name属性
    修改私有的name属性值，并调用getName()的方法打印name属性值
     */
        //获取class类
        Class privateTestClass =PrivateTest.class;
        //创建PrivateTest类
        PrivateTest privateTest = new PrivateTest();
        //获取私有字段name属性
        Field privateTestClassDeclaredField  =privateTestClass.getDeclaredField("name");
        if(privateTestClassDeclaredField.getModifiers() == Modifier.PRIVATE){
            //暴力破解
            privateTestClassDeclaredField.setAccessible(true);
        }
        //修改name的属性值
        privateTestClassDeclaredField.set(privateTest,"小孩");
        System.out.println(privateTestClassDeclaredField.get(privateTest));
    }
}
