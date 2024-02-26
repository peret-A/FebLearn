package com.bdqn.test01;

import java.sql.SQLException;
import java.util.Scanner;

public class Test {
/**
 * @author liuziyang
 * @data 2024-02-26-19:29
 */

//作为订单系统的入口
public static void main(String[] args) throws SQLException {
    //创建Scanner对象
    Scanner scanner =new Scanner(System.in);
    int input;
    do {
        Mean.mainMenu();
        System.out.print("输入你的选择: ");
        input =scanner.nextInt();
        switch (input){
            case 0:System.exit(0);
                break;
            case 1:
                Restaurant.login();
                break;
            case 2:
                Restaurant.enroll();
                break;
            default:
                System.out.println("选择错误,重新选择");
                break;
        }
    }while (input!=0);
}
}
