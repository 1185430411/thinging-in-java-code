package com.jay.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class EchoServer {
    private int port;

    public EchoServer(int port){
        this.port=port;
    }

    public void run() throws Exception{
        //这个类是用来处理IO操作的多线程事件循环器，boss用来接受数据，worker用来处理数据。
        EventLoopGroup boss=new NioEventLoopGroup();
        EventLoopGroup worker=new NioEventLoopGroup();

        try {
            ServerBootstrap b=new ServerBootstrap();  //一个启动NIO服务的辅助启动类。
            b.group(boss,worker)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ByteBuf byteBuf= Unpooled.copiedBuffer("$_".getBytes());
                            //单条数据最大长度为1024，分隔符缓冲对象为byteBuf
                            socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(1024,byteBuf));
                            socketChannel.pipeline().addLast(new StringDecoder());
                            socketChannel.pipeline().addLast(new EchoServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG,128)
                    .childOption(ChannelOption.SO_KEEPALIVE,true);

            //绑定端口
            ChannelFuture channelFuture=b.bind(port).sync();

            //等待服务器socket关闭
            channelFuture.channel().closeFuture().sync();
        }finally {
            worker.shutdownGracefully();
            boss.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception{
        new EchoServer(8080).run();
    }
}
