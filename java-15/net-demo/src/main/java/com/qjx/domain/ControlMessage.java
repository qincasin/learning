package com.qjx.domain;

/**
 * Created by qincasin on 2020/12/13.
 */
public class ControlMessage extends Message{

    //电量状态
    private byte charge;
    //设备imsi
    private String imsi;
    //控制类型
    private byte controlType;

    private short controlRet;

    public byte getCharge() {
        return charge;
    }

    public void setCharge(byte charge) {
        this.charge = charge;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public byte getControlType() {
        return controlType;
    }

    public void setControlType(byte controlType) {
        this.controlType = controlType;
    }

    public short getControlRet() {
        return controlRet;
    }

    public void setControlRet(short controlRet) {
        this.controlRet = controlRet;
    }
}
