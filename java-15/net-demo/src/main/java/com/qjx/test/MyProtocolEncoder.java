package com.qjx.test;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.StandardCharsets;

/**
 * Created by qincasin on 2020/12/13.
 */
public class MyProtocolEncoder extends MessageToByteEncoder<MyProtocolBean> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MyProtocolBean msg, ByteBuf out) throws Exception {
        if(msg == null){
            throw new Exception("msg is null");
        }
        out.writeByte(msg.getType());
        out.writeByte(msg.getFlag());
        out.writeInt(msg.getLength());
        out.writeBytes(msg.getContent().getBytes(StandardCharsets.UTF_8));

    }
}
