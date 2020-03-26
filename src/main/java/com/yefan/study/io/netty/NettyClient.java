package com.yefan.study.io.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.ReferenceCountUtil;

public class NettyClient {
    public static void main(String[] args) {
        new NettyClient().clientStart();
    }

    private void clientStart() {
        //线程池,workerGroup 负责连接口的 IO 处理
        EventLoopGroup workers = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();

        bootstrap.group(workers)
                //建立连接通道后的类型
                .channel(NioSocketChannel.class)
                //添加链接通道监听器
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        System.out.println("channel initial");
                        //在通道上添加监听器
                        socketChannel.pipeline().addLast(new ClientHandler());
                    }
                });
        try {
            System.out.println("start to connect server");
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8888)
                    .sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            workers.shutdownGracefully();
        }

    }

    class ClientHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println(" channel is active");
            ChannelFuture future = ctx.writeAndFlush(Unpooled.copiedBuffer("hello server".getBytes()));
            future.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    System.out.println("send success!");
                }
            });
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            try {
                ByteBuf byteBuf = (ByteBuf) msg;
                System.out.println(byteBuf.toString());
            }finally {
                ReferenceCountUtil.release(msg);
            }


        }
    }
}
