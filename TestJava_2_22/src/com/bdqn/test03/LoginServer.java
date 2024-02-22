package com.bdqn.test03;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
    /**
     *
     * @author liuziyang
     * @version jdk21
     *
     */
    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(8800);
            //循环监听
            while (true){

                //创建Socket链接客户端
                socket = serverSocket.accept();
                MyThread myThread =new MyThread(socket);
                myThread.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
