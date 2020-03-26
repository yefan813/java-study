package com.yefan.study.io.bio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @author yefan
 */
public class BioServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        System.out.println("启动服务器...");
        serverSocket.bind(new InetSocketAddress("127.0.0.1", 8888));
        while (true) {
            System.out.println("等待客户端链接...");
            //accept()方法阻塞，直到有新的连接
            final Socket socket = serverSocket.accept();
            System.out.println("客户已连接");
            new Thread(()->{
               handle(socket);
            }).start();
        }
    }


    private static void handle(Socket socket) {
        try {
            byte[] bytes = new byte[1024];

            System.out.println("读数据..");
            //read block method
            int len = socket.getInputStream().read(bytes);
            System.out.println(new String(bytes,0,len));

            System.out.println("写数据..");
            //write block method
            socket.getOutputStream().write(bytes,0,len);
            socket.getOutputStream().flush();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
