package com.bdqn.test04;

import java.io.IOException;
import java.net.*;

public class Send {
/**
 * @author liuziyang
 * @data 2024-02-22-15:12
 */
/*
 * 示例05：模拟客户咨询问题，实现发送方发送咨询问题，接收方接收并显示发送来的咨询问题。
 *
 * 发送方实现步骤如下：
 * 	（1）获取本地主机的InetAddress对象。
 * 	（2）创建DatagramPacket对象，封装要发送的信息。
 * 	（3）利用DatagramSocket对象将DatagramPacket对象数据发送出去。
 */

public static void main(String[] args) {
    DatagramSocket ds = null;
    InetAddress ia = null;
    String mess = "你好，我想咨询一个问题。";
    try {

        //获取本地主机地址
        ia = InetAddress.getByName("localhost");
        //创建DatagramPacket对象，封装数据
        DatagramPacket dp = new DatagramPacket(mess.getBytes(), mess.getBytes().length, ia, 8800);
        //创建DatagramSocket对象，向服务器发送数据
        ds = new DatagramSocket();
        ds.send(dp);
    } catch (UnknownHostException e) {
        e.printStackTrace();
    } catch (SocketException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally{
        ds.close();
    }

}
}
