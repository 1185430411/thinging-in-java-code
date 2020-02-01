package com.jay.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    //当客户端接收到数据的时候，这个方法就会被调用。
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String s=(String)msg;
        System.out.println(s);

        String ans=new String(s).equalsIgnoreCase("time")?new Date(System.currentTimeMillis()).toString():"error";
        byte[]list=(ans+System.getProperty("line.separator")).getBytes();
        ByteBuf  byteBuf= Unpooled.buffer(list.length);
        byteBuf.writeBytes(list);
        ctx.writeAndFlush(byteBuf);
    }

    /*@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ctx.writeAndFlush(msg);  //返回信息，将传入的信息返回到命令行上
    }*/

    /*@Override
    public void channelActive(final ChannelHandlerContext ctx) { // (1)
        final ByteBuf time = ctx.alloc().buffer(4); // (2)
        time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));

        final ChannelFuture f = ctx.writeAndFlush(time); // (3)
        f.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) {
                assert f == future;
                ctx.close();
            }
        }); // (4)
    }*/

    //出现异常就关闭
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
