package com.qjx.domain;

/**
 * Created by qincasin on 2020/12/13.
 */
public class MqReceiveMessage {
    private String imsi;
    private byte type;

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }
}
