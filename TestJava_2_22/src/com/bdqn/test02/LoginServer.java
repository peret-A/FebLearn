package com.bdqn.test02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
    public static void main(String[] args) {
        //创建流
        OutputStream outputStream=null;
        InputStream inputStream =null;
        ObjectInputStream objectInputStream =null;
        //创建ServerSocket链接，端口号8800
        try {
            ServerSocket serverSocket =new ServerSocket(8800);

            //监听客户端信息
            Socket socket =serverSocket.accept();

            //反序列化
            inputStream = socket.getInputStream();
            objectInputStream=new ObjectInputStream(inputStream);
            User user = (User) objectInputStream.readObject();
            System.out.println("我是服务端，你好 " + user.getName() + "," + user.getPwd());
            socket.shutdownInput();
            //给客户端反馈
            String information ="客户端，你好";
            outputStream=socket.getOutputStream();
            outputStream.write(information.getBytes());
            socket.shutdownOutput();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
           if(objectInputStream!=null){
               try {
                   objectInputStream.close();
               } catch (IOException e) {
                   throw new RuntimeException(e);
               }
           }
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
