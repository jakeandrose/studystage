package com.example.webservice;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端简单程序，用于接收并处理客户端发送过来的请求，并将响应结果发送给客户端
 */
public class ServiceTest {

    @Test
    public void ServiceTest() throws Exception {

        ServerSocket serverSocket = new ServerSocket(10001);

        Socket socket = serverSocket.accept();

        /**
         * 读取客户端发送过来的请求
         */
        byte []bytes = new byte[1024];
        InputStream inputStream = socket.getInputStream();
        inputStream.read(bytes);
        System.out.println("服务器端读取到客户端的请求信息是：" + new String(bytes));


        /**
         * 将响应结果发送给客户端
         */
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("服务器端接收到了客户端的请求并处理了".getBytes());



        socket.close();
        serverSocket.close();


    }
}
