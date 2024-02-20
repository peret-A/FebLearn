package com.bdqn.test01;

import java.io.File;
import java.lang.reflect.Field;


public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取CLass类
        Class personClass=Class.forName("com.bdqn.entity.Person");
        //获取字段Field类
        // Field[] getFields() 返回一个包含某些 Field 对象的数组，这些对象反映此 Class 对象所表示的类或接口的所有可访问公共字段。
//        Field[] personClassFields =personClass.getFields();
        //Field[] getDeclaredFields()  返回 Field 对象的一个数组，这些对象反映此 Class 对象所表示的类或接口所声明的所有字段。
        Field[] personClassDeclaredFields=personClass.getDeclaredFields();
        //遍历字段
        for(Field field:personClassDeclaredFields){
            System.out.println("字段修饰符: "+field.getModifiers());
            System.out.println("字段类型: " + field.getType());
            System.out.println("字段名称: " +field.getName());
        }
    }
}
