package com.jay.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

public class TimeClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        String s=(String)msg;
        System.out.println(s);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String msg="time"+System.getProperty("line.separator");
        byte[]list=msg.getBytes();
        for(int i=0;i<100;i++) {
            /*ByteBuf byteBuf = Unpooled.copiedBuffer(msg.getBytes());
            ctx.writeAndFlush(byteBuf);*/
            ByteBuf byteBuf=Unpooled.buffer(list.length);
            byteBuf.writeBytes(list);
            ctx.writeAndFlush(byteBuf);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
