package com.qjx.test;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by qincasin on 2020/12/13.
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        MyProtocolBean myProtocolBean = new MyProtocolBean((byte)0xA, (byte)0xC, "Hello,Netty".length(), "Hello,Netty");
        ctx.writeAndFlush(myProtocolBean);    }
}
