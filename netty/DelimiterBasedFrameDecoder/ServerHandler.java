package com.jay.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    int count=0;
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        /*
        * 首先DelimiterBasedFrameDecoder自动对请求信息进行了解码，后续的ChannelHandler接收到的msg对象是完整的信息包
        * StringDecoder进行解码成字符串
        * EchoServerHandler获取到该msg
        * */
        String body=(String)msg;
        System.out.println("this is "+ ++count +" times receive client:"+msg);
        //$_ 被过滤掉，此处需要重新加上
        body+="$_";
        ByteBuf echo= Unpooled.copiedBuffer(body.getBytes());
        ctx.writeAndFlush(echo);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
