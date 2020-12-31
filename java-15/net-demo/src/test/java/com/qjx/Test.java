package com.qjx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * Created by qincasin on 2020/12/13.
 */
public class Test {
    public static void main(String[] args) {
        /**
         * 03 1F 8607650488066620 003F190102FFB0FF30FF80220242EA3CFC41FE9EBF80000007B7DA 样例数据
         * 03                              msgId  1
         *     1F                          长度 1
         *     8607650488066620             8
         *     00 3F19                     设备信息   1+2
         *     01 02FFB0FF30FF8022         加速度     1+8
         *     02 42EA3CFC41FE9EBF         经纬度     1+8
         *     80 000007                   用户心跳    1+3
         * B7DA 样例数据                    crc        2
         */
        float f  = 0x42007E6A;
        int i  = 0x42007E6A;
        float f2 = 0x42EA3CFC;
        float f3 = 0x41FE9EBF;

        System.out.println(Float.intBitsToFloat(i));

        ByteBuf buffer = Unpooled.buffer(100);
//        buffer.writeInt(i);
//        int i1 = buffer.readInt();
//        System.out.println(i+" "+Float.intBitsToFloat(i1));
//        buffer.discardReadBytes();

//        buffer.clear();
        short device = 0x3F19;
        buffer.writeShort(device);
        byte deviceDataH = buffer.readByte();
        byte deviceDataL = buffer.readByte();
        System.out.println(deviceDataH);
        System.out.println(deviceDataL);
        buffer.clear();

        buffer.writeByte(0x3F);
        buffer.writeByte(0x19);
        byte b1 = buffer.readByte();
        byte b2 = buffer.readByte();
//        b1 & 32
        System.out.println(b1 + " " + b2);

        //02 FFB0 FF30 FF80 22
        byte devent = 0x02;
        buffer.writeByte(devent);
        buffer.writeByte(0x00);
        buffer.writeByte(0x50);
        buffer.writeByte(0x00);
        buffer.writeByte(0x20);
        buffer.writeByte(0x00);
        buffer.writeByte(0x30);
        buffer.writeByte(0x22);
//        buffer.writeByte(0xFF);
//        buffer.writeByte(0xB0);
//        buffer.writeByte(0xFF);
//        buffer.writeByte(0x30);
//        buffer.writeByte(0xFF);
//        buffer.writeByte(0x80);
//        buffer.writeByte(0x22);
        byte b = buffer.readByte();
        short x = buffer.readShort();
        short y = buffer.readShort();
        short z = buffer.readShort();
        byte angle = buffer.readByte();
        System.out.println(b + " " + x + " " + y + " " + z + " " + angle);

        buffer.clear();

//        buffer.writeByte()
        String s = Integer.toBinaryString(63);
        System.out.println(s);


        buffer.writeByte(0x3F);
        buffer.writeByte(0x19);
        byte b3 = buffer.readByte();
        byte b4 = buffer.readByte();
//        b1 & 32
        System.out.println(b3 + " " + b4);

        int i2 = b3 >> 5 & 7;
        int i1 = b3 & 31;
        System.out.println(i1 + " " + i2);

        buffer.clear();

        buffer.writeByte(0x07);

        byte b5 = buffer.readByte();
        int i3 = b5 & 7;
        System.out.println(i3);

        System.out.println(b5 >> 7);

        byte a = 0x1F;
        System.out.println(a);

        byte bbb = 0x1F;
        System.out.println(bbb);

    }

}
