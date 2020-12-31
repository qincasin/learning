package com.qjx.domain;

/**
 * Created by qincasin on 2020/12/13.
 */
public class HeartBeatMessage extends Message{
    //设备imsi
    private String imsi;
    //电量状态
    private byte charge;
    //路锥状态
    private byte status;
    //gps定位状态 1 成功  0 没定位成功
    private byte gpsStatus;
    //gps 经度  2 西经 3 东经
    private byte gpsWE;
    // gps 经度信息 4个字节
    private int ddddmmssWE;
    //gps 纬度  4 南纬  5 北纬
    private byte gpsSN;
    //gps 纬度信息 4个字节
    private int ddddmmssSN;

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public byte getCharge() {
        return charge;
    }

    public void setCharge(byte charge) {
        this.charge = charge;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public byte getGpsStatus() {
        return gpsStatus;
    }

    public void setGpsStatus(byte gpsStatus) {
        this.gpsStatus = gpsStatus;
    }

    public byte getGpsWE() {
        return gpsWE;
    }

    public void setGpsWE(byte gpsWE) {
        this.gpsWE = gpsWE;
    }

    public int getDdddmmssWE() {
        return ddddmmssWE;
    }

    public void setDdddmmssWE(int ddddmmssWE) {
        this.ddddmmssWE = ddddmmssWE;
    }

    public byte getGpsSN() {
        return gpsSN;
    }

    public void setGpsSN(byte gpsSN) {
        this.gpsSN = gpsSN;
    }

    public int getDdddmmssSN() {
        return ddddmmssSN;
    }

    public void setDdddmmssSN(int ddddmmssSN) {
        this.ddddmmssSN = ddddmmssSN;
    }

}
