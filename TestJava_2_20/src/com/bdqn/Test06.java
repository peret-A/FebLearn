package com.bdqn;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test06 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        /*
        1.利用Class类的forName方法得到File类
        2.在控制台打印File类的所有构造器
        3.通过newInstance的方法创建File对象，并创建D:\mynew.txt文件
         */
        //获取Class类
        Class fileClass =Class.forName("java.io.File");
        //在控制台打印File类的所有构造器
        Constructor[] fileClassDeclaredConstructors =fileClass.getDeclaredConstructors();
        //遍历
        for(Constructor constructor:fileClassDeclaredConstructors){
            System.out.println("构造方法的修饰符: " + (constructor.getModifiers() == 1 ? "public" : "private"));
            String name =constructor.getName().substring(constructor.getName().lastIndexOf(".")+1);
            System.out.println("构造方法的名称: " + name);
            System.out.print("构造方法的参数: ");
            //获取构造方法的参数列表
            Class[] constructorParameterTypes=constructor.getParameterTypes();
            for(Class type:constructorParameterTypes){
                System.out.print("  "+type.getName());
            }
            System.out.println();
            System.out.println();
        }
        //通过newInstance的方法创建File对象，并创建D:\mynew.txt文件
        Constructor constructor=fileClass.getConstructor(String.class);
        File file =(File)constructor.newInstance("D:\\mynew.txt");
        file.createNewFile();
    }
}
