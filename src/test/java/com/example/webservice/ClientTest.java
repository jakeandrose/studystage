package com.example.webservice;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


/**
 * 简单的客户端程序主要为了测试客户端和服务端链接后，客户端向服务端发送请求并接收服务端发送过来的响应过程
 */
public class ClientTest {

    @Test
    public void clientTest () throws Exception {

        /**
         * 客户端和本地服务端进行链接请求
         */
        Socket socket = new Socket("127.0.0.1",10001);

        OutputStream outputStream = socket.getOutputStream();

        /**
         * 客户端向服务器端发送请求
         */
        outputStream.write("客户端向服务器端发送请求".getBytes());


        /**
         * 客户端接收从服务端发送过来的响应
         */
        byte []bytes = new byte[1024];
        InputStream inputStream = socket.getInputStream();
        inputStream.read(bytes);
        System.out.println("客户端接收到的响应结果:" + new String(bytes));

        socket.close();
    }
}
