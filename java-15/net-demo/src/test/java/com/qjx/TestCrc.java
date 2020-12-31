package com.qjx;

import com.qjx.util.CRC16Util;
import com.qjx.util.CheckUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * Created by qincasin on 2020/12/14.
 */
public class TestCrc {
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
        ByteBuf buffer = Unpooled.buffer(100);
        buffer.writeByte(0x03);
        buffer.writeByte(0x1F);

        buffer.writeByte(0x86);
        buffer.writeByte(0x07);
        buffer.writeByte(0x65);
        buffer.writeByte(0x04);
        buffer.writeByte(0x88);
        buffer.writeByte(0x06);
        buffer.writeByte(0x66);
        buffer.writeByte(0x20);

        buffer.writeByte(0x00);
        buffer.writeByte(0x3F);
        buffer.writeByte(0x19);

        //01 02FFB0FF30FF8022
        buffer.writeByte(0x01);
        buffer.writeByte(0x02);
        buffer.writeByte(0xFF);
        buffer.writeByte(0xB0);
        buffer.writeByte(0xFF);
        buffer.writeByte(0x30);
        buffer.writeByte(0xFF);
        buffer.writeByte(0x80);
        buffer.writeByte(0x22);

        //02 42EA3CFC41FE9EBF
        buffer.writeByte(0x02);
        buffer.writeByte(0x42);
        buffer.writeByte(0xEA);
        buffer.writeByte(0x3C);
        buffer.writeByte(0xFC);
        buffer.writeByte(0x41);
        buffer.writeByte(0xFE);
        buffer.writeByte(0x9E);
        buffer.writeByte(0xBF);

        //80 000007
        buffer.writeByte(0x80);
        buffer.writeByte(0x00);
        buffer.writeByte(0x00);
        buffer.writeByte(0x00);
        buffer.writeByte(0x07);

        byte[] array = buffer.array();
        byte b = CheckUtils.sumCheck(array);
        int i = CheckUtils.calcCrc16(array);

        float f = 0xB7DA;
        System.out.println(f);

        System.out.println(i);

        System.out.println(b);

        System.out.println(Integer.toHexString(i));

        System.out.println(CRC16Util.crc16(array));


        buffer.writeCharSequence("8607650488066620", Charset.defaultCharset());




    }
}
