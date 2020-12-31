package com.qjx.domain;

/**
 * Created by qincasin on 2020/12/13.
 */
public abstract class Message {
    protected byte type;

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }
}
