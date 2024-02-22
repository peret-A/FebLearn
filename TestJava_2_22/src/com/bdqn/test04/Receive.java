package com.bdqn.test04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receive {
/**
 * @author liuziyang
 * @data 2024-02-22-15:16
 */
public static void main(String[] args) {
    /*
     * 示例05：模拟客户咨询问题，实现发送方发送咨询问题，接收方接收并显示发送来的咨询问题。
     *
     * 接收方实现步骤如下：
     * 	（1）创建DatagramPacket对象，准备接收封装的数据。
     * 	（2）创建DatagramSocket对象，接收数据保存于DatagramPacket对象中。
     * 	（3）利用DatagramPacket对象处理数据。
     */

    DatagramSocket ds = null;
    //创建DatagramPacket对象，用来准备接收数据
    byte[] buf = new byte[1024];
    DatagramPacket dp = new DatagramPacket(buf, 1024);
    try {
        //创建DatagramSocket对象，接收数据
        ds = new DatagramSocket(8800);
        ds.receive(dp);
        //显示接收到的信息
        String mess = new String(dp.getData(), 0, dp.getLength());
        System.out.println(dp.getAddress().getHostAddress()+"说："+mess);
    } catch (SocketException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }finally{
        ds.close();
    }



}


}
