package com.bdqn.test02;

import java.io.*;
import java.net.Socket;

public class LoginSocket {
    public static void main(String[] args) {
        //创建流
        OutputStream outputStream=null;
        ObjectOutputStream objectOutputStream =null;
        InputStream inputStream =null;
        BufferedReader bufferedReader =null;
        //创建客户端Socket链接,链接到本机 localhost 端口号 8800
        try {
            Socket socket =new Socket("localhost",8800);
            //创建User对象
            User user =new User("小明",123456);
            //将对象发送给服务端
            outputStream = socket.getOutputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(user);
            socket.shutdownOutput();
            //关闭发送流
            //接收服务端反馈信息
            inputStream=socket.getInputStream();
            bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String information = null;
            while( (information=bufferedReader.readLine())!=null){
                System.out.println(information);
            }
            socket.shutdownInput();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(bufferedReader!=null){
                try {
                    bufferedReader.close();
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
            if(objectOutputStream!=null){
                try {
                    objectOutputStream.close();
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
