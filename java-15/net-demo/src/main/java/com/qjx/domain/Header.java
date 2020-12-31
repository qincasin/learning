package com.qjx.domain;

/**
 * Created by qincasin on 2020/12/13.
 */
public class Header {

    // 包头
    private short headFlag;
    //头部头
    private byte syn;
    //功能码
    private byte funcCode;
    //电量状态
    private byte Charge;
    //设备imsi
    private String imsi;

    public short getHeadFlag() {
        return headFlag;
    }

    public void setHeadFlag(short headFlag) {
        this.headFlag = headFlag;
    }

    public byte getSyn() {
        return syn;
    }

    public void setSyn(byte syn) {
        this.syn = syn;
    }

    public byte getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(byte funcCode) {
        this.funcCode = funcCode;
    }

    public byte getCharge() {
        return Charge;
    }

    public void setCharge(byte charge) {
        Charge = charge;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }
}
