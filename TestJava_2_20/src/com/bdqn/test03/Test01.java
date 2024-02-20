package com.bdqn.test03;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test01 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        /*
        1)创建Student类，类中有属性name和age并封装属性
        2)重载Student的构造函数，一个是无参构造，另一个是带两个参数的有参构造，要求在构造函数打印提示信息
        3)创建带main函数的NewInstanceTest类，利用Class类得到Student对象
        4)通过上述获取的Class对象分别调用Student有参函数和无参函数
         */
        //获取class类
        Class studentClass =Student.class;
        //通过class获取student的无参函数
        Constructor constructor1 =studentClass.getDeclaredConstructor();
        Student student1=(Student)constructor1.newInstance();
        //通过class获取student的有参函数
        Constructor constructor2 =studentClass.getDeclaredConstructor(String.class,int.class);
        Student student2 = (Student)constructor2.newInstance("小明",25);

    }
}
