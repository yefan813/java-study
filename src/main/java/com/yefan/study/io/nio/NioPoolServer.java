package com.yefan.study.io.nio;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * NIO 线程池
 * @author yefan
 */
public class NioPoolServer {
    ExecutorService pool = Executors.newFixedThreadPool(50);

    private Selector selector;

    public void initServer(int port) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // set block is false
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(8888));

        System.out.println("server is started, listen on :" + serverSocketChannel.getLocalAddress());
        selector = Selector.open();
        //注册监听客户端连接事件
        //注册 accept 监听事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("server run success!");
    }

    public static void main(String[] args) throws IOException {
        NioPoolServer server = new NioPoolServer();
        server.initServer(8000);
        server.listen();
    }



    public void listen() throws IOException {
        while (true) {
            System.out.println("selector 轮训是否有事件..");
            // block method
            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while(iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                handle(key);
            }

        }
    }

    private void handle(SelectionKey key) throws IOException {
        if(key.isAcceptable()) {
            System.out.println("有客户端链接..");
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            SocketChannel channel = serverSocketChannel.accept();
            channel.configureBlocking(false);
            channel.register(key.selector(),SelectionKey.OP_READ);
        }

        if(key.isReadable()) {
            System.out.println("客户端写入数据...");
            key.interestOps(key.interestOps() & (~SelectionKey.OP_READ));
            pool.execute(new ThreadHandleChannel(key));
        }
    }


    class ThreadHandleChannel implements Runnable {
        private SelectionKey selectionKey;


        public ThreadHandleChannel(SelectionKey selectionKey) {
            this.selectionKey = selectionKey;
        }

        @Override
        public void run() {
            System.out.println("读取客户端传入数据...");
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            //分配内存
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            ByteOutputStream byteOutputStream = new ByteOutputStream();
            try {
                //从通道读取数据
                int size = 0;
                while ((size = socketChannel.read(buffer)) > 0) {
                    buffer.flip();
                    byteOutputStream.write(buffer.array(),0,size);
                    buffer.clear();
                }
                byte[] content = byteOutputStream.toByteArray();

                ByteBuffer writeBuffer = ByteBuffer.allocate(content.length);
                writeBuffer.put(content);
                writeBuffer.flip();
                //write data
                socketChannel.write(writeBuffer);
                if(size == -1){
                    socketChannel.close();
                    return;
                }
                selectionKey.interestOps(selectionKey.interestOps() | SelectionKey.OP_READ);
                selectionKey.selector().wakeup();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
