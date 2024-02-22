package com.bdqn.test01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
    //服务端
    public static void main(String[] args) {
        //创建写入流 和 高效读取流
        OutputStream outputStream = null;
        InputStream inputStream =null;
        BufferedReader bufferedReader =null;
        //创建服务端serverSotket链接,端口号8800
        try {
            ServerSocket serverSocket =new ServerSocket(8800);
            //时刻准备接收客户端发送的信息
            Socket socket =serverSocket.accept();
            //接收信息
            inputStream=socket.getInputStream();
            bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String information=null;
            while ((information=bufferedReader.readLine())!=null){
                System.out.println(information);
            }
            socket.shutdownInput();
            outputStream=socket.getOutputStream();
            //返回信息
            information = "你好客户端，我是服务段";
            outputStream.write(information.getBytes());
            socket.shutdownOutput();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            //关闭流
            if(outputStream!=null){
                try {
                    outputStream.close();
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
            if(bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
