package com.bdqn.test01;

import java.io.*;
import java.net.Socket;

public class LoginClient {
    public static void main(String[] args) {
        //客户端
        //创建输入 和 高效读取流
        OutputStream outputStream = null;
        InputStream inputStream =null;
        BufferedReader bufferedReader =null;
        //建立客户端Socket链接，指定服务器的位置为本机 localhost 端口号8800
        Socket socket;

        {
            try {
                socket = new Socket("localhost",8800);
                //打开输入流
                outputStream = socket.getOutputStream();
                //向服务端发送信息
                String information = "账号: root , 密码: 123456";
                outputStream.write(information.getBytes());
                socket.shutdownOutput();
                //接收客户端信息
                inputStream=socket.getInputStream();
                bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                while ((information=bufferedReader.readLine())!=null){
                    System.out.println(information);
                }
                socket.shutdownInput();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally {
                //关闭流
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
