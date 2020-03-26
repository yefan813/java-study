package com.yefan.study.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO Single Thread
 * @author yefan
 * serverSocket 类似电源插板，上面有很多插口
 * Selector 大管家
 * SelectionKey 是在 serverSocket 插孔上面安装的监听器
 */
public class NioServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1", 8888));
        // set block is false
        serverSocketChannel.configureBlocking(false);

        System.out.println("server is started, listen on :" + serverSocketChannel.getLocalAddress());
        Selector selector = Selector.open();
        //注册监听客户端连接事件
        //注册 accept 监听事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            //轮训查看，阻塞方法。监听是否有事件发生
            System.out.println("轮训查看是否有监听事件发生...");
            selector.select();
            //监听到有哪些 key 事件发生
            System.out.println("监听到事件发生...");
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while(iterator.hasNext()) {
                SelectionKey key = iterator.next();
                //需要将 key remove 掉不然下次轮训还会处理
                iterator.remove();
                handle(key);
            }
        }


    }

    private static void handle(SelectionKey key) {
        if (key.isAcceptable()) {
            //获得 channel
            System.out.println("accept事件发生，建立一条通道");
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            try {
                //建立 channel
                serverSocketChannel.accept();
                //设置通道是否阻塞
                serverSocketChannel.configureBlocking(false);
                //在通道上放置一个 read 的监听事件
                System.out.println("在 channel 通道上注册 read 事件...");
                serverSocketChannel.register(key.selector(),SelectionKey.OP_READ);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(key.isReadable()) {
            System.out.println("read事件发生...");
            SocketChannel socketChannel = (SocketChannel) key.channel();
            //分配内存
            ByteBuffer buffer = ByteBuffer.allocate(512);
            buffer.clear();
            try {
                //从通道读取数据
                System.out.println("读取数据...");
                int len = socketChannel.read(buffer);
                if (len != -1) {
                    System.out.println(new String(buffer.array(),0,len));
                }
                ByteBuffer bufferToWrite = ByteBuffer.wrap("hello client".getBytes());
                //向通道写数据
                socketChannel.write(bufferToWrite);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
