package com.yefan.study.io.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author yefan
 */
public class NettyServer {
    public static void main(String[] args) {
        new Server(8888).start();
    }

    static class Server {
        int port = 8888;

        public Server(int port) {
            this.port = port;
        }

        public void start() {
            //线程池,bossGroup负责连接
            NioEventLoopGroup bossGroup = new NioEventLoopGroup();
            //线程池,workerGroup 负责连接口的 IO 处理
            NioEventLoopGroup workerGroup = new NioEventLoopGroup();
            ServerBootstrap serverBootstrap = new ServerBootstrap();

            serverBootstrap.group(bossGroup,workerGroup)
                    //建立连接通道后的类型
                    .channel(NioServerSocketChannel.class)
                    //当客户端连接后给一个监听器
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            //channel初始化,添加对通道的 handler
                            socketChannel.pipeline().addLast(new Handler());
                        }
                    });

            try {
                //server 监听端口启动服务
                ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
                channelFuture.channel().closeFuture().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                workerGroup.shutdownGracefully();
                bossGroup.shutdownGracefully();
            }

        }
    }

    static class Handler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println("读取数据....");
            ByteBuf byteBuf = (ByteBuf) msg;
            System.out.println(byteBuf.toString());

            ctx.writeAndFlush(msg);
            ctx.close();
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            cause.printStackTrace();
            ctx.close();
        }
    }
}
