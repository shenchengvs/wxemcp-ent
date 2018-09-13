package com.holley.wxemcp.ent.common.msg;

public class MsgStationIP extends MsgBase {

    int    IP1_1;
    int    IP1_2;
    int    IP1_3;
    int    IP1_4;
    short  port1;
    int    IP2_1;
    int    IP2_2;
    int    IP2_3;
    int    IP2_4;
    short  port2;
    String apn;

    public int getIP1_1() {
        return IP1_1;
    }

    public void setIP1_1(int iP1_1) {
        IP1_1 = iP1_1;
    }

    public int getIP1_2() {
        return IP1_2;
    }

    public void setIP1_2(int iP1_2) {
        IP1_2 = iP1_2;
    }

    public int getIP1_3() {
        return IP1_3;
    }

    public void setIP1_3(int iP1_3) {
        IP1_3 = iP1_3;
    }

    public int getIP1_4() {
        return IP1_4;
    }

    public void setIP1_4(int iP1_4) {
        IP1_4 = iP1_4;
    }

    public short getPort1() {
        return port1;
    }

    public void setPort1(short port1) {
        this.port1 = port1;
    }

    public int getIP2_1() {
        return IP2_1;
    }

    public void setIP2_1(int iP2_1) {
        IP2_1 = iP2_1;
    }

    public int getIP2_2() {
        return IP2_2;
    }

    public void setIP2_2(int iP2_2) {
        IP2_2 = iP2_2;
    }

    public int getIP2_3() {
        return IP2_3;
    }

    public void setIP2_3(int iP2_3) {
        IP2_3 = iP2_3;
    }

    public int getIP2_4() {
        return IP2_4;
    }

    public void setIP2_4(int iP2_4) {
        IP2_4 = iP2_4;
    }

    public short getPort2() {
        return port2;
    }

    public void setPort2(short port2) {
        this.port2 = port2;
    }

    public String getApn() {
        return apn;
    }

    public void setApn(String apn) {
        this.apn = apn;
    }

}
