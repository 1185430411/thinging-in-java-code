package com.jay.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.FileRegion;
import io.netty.channel.SimpleChannelInboundHandler;

import java.io.File;
import java.io.RandomAccessFile;

public class FileServerHandler extends SimpleChannelInboundHandler<String> {

    private static final String CR=System.getProperty("line.separator");

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
        File file=new File(s);
        if(file.exists()){
            if(!file.isFile()) {
                ctx.writeAndFlush("not a file:" + file + CR);
                return;
            }

            ctx.write(file+" "+file.length()+CR);
            RandomAccessFile randomAccessFile=new RandomAccessFile(s,"r");
            FileRegion fileRegion=new DefaultFileRegion(randomAccessFile.getChannel(),0,randomAccessFile.length());
            ctx.write(fileRegion);
            ctx.writeAndFlush(CR);
            randomAccessFile.close();
        }else{
            ctx.writeAndFlush("file not found:"+file+CR);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
