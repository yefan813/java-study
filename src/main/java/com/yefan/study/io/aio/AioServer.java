package com.yefan.study.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Asynchronous 异步 io
 */
public class AioServer {
    public static void main(String[] args) throws IOException, InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withCachedThreadPool(executorService,2);
        AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open(channelGroup);
        serverSocketChannel.bind(new InetSocketAddress(8888));
        //此处非阻塞,执行完成后就干下一步，返回结果会调用CompletionHandler#completed来处理
        serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            @Override
            public void completed(AsynchronousSocketChannel channel, Object attachment) {
                serverSocketChannel.accept(null,this);
                try {
                    System.out.println(channel.getRemoteAddress());
                    ByteBuffer allocate = ByteBuffer.allocate(1024);
                    channel.read(allocate, allocate, new CompletionHandler<Integer, ByteBuffer>() {
                        @Override
                        public void completed(Integer result, ByteBuffer attachment) {
                            attachment.flip();
                            System.out.println(new String(attachment.array(),0,result));
                            channel.write(ByteBuffer.wrap("hello client".getBytes()));
                        }

                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {

                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                exc.printStackTrace();
            }
        });

        while (true) {
            Thread.sleep(1000);
        }
    }
}
