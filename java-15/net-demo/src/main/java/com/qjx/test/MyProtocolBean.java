package com.qjx.test;

/**
 * Created by qincasin on 2020/12/13.
 *
 * {
 *     "msgId": "03",
 *     "length": 62,
 *     "devAddr": "8607650488066620",
 *     "body": {
 *         "deviceInfo": {
 *             "type": "00",
 *             "nbSignal": 25,
 *             "version": "001",
 *             "charge": 31
 *         },
 *         "heartbeatInfo": {
 *             "type": "80",
 *             "dataH": "00",
 *             "dataM": "00",
 *             "dataL": 0,
 *             "brand": 0,
 *             "rfu": "0000",
 *             "charge": 7
 *         },
 *         "sensorInfo": {
 *             "type": "01",
 *             "event": "02",
 *             "x": 176,
 *             "y": 48,
 *             "z": 128,
 *             "angle": 34
 *         },
 *         "gpsInfo": {
 *             "type": "02",
 *             "lat": 31.827513,
 *             "lng": 117.11911
 *         }
 *     },
 *     "isChecked": true,
 *     "crcSum": 47066,
 *     "crc": "B7DA"
 * }
 */
public class MyProtocolBean {
    // 0xA a系统  0xB b系统
    private byte type;

    //信息标志  0xA 表示心跳包    0xC 表示超时包  0xC 业务信息包
    private byte flag;

    private int length;

    private String content;

    public MyProtocolBean(byte type, byte flag, int length, String content) {
        this.type = type;
        this.flag = flag;
        this.length = length;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public byte getFlag() {
        return flag;
    }

    public void setFlag(byte flag) {
        this.flag = flag;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "MyProtocolBean{" +
                "type=" + type +
                ", flag=" + flag +
                ", length=" + length +
                ", content='" + content + '\'' +
                '}';
    }
}
