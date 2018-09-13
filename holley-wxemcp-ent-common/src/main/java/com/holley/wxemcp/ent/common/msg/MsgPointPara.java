package com.holley.wxemcp.ent.common.msg;

import java.io.Serializable;

public class MsgPointPara implements Serializable {

    private static final long serialVersionUID = 1L;
    // short pnNum;
    short                     devID;
    short                     pnID;
    short                     devType;
    short                     commRate;
    short                     protocolid;
    String                    commaddr;
    String                    password;
    short                     commContrl;

    public short getDevID() {
        return devID;
    }

    public void setDevID(short devID) {
        this.devID = devID;
    }

    public short getPnID() {
        return pnID;
    }

    public void setPnID(short pnID) {
        this.pnID = pnID;
    }

    public short getDevType() {
        return devType;
    }

    public void setDevType(short devType) {
        this.devType = devType;
    }

    public short getCommRate() {
        return commRate;
    }

    public void setCommRate(short commRate) {
        this.commRate = commRate;
    }

    public short getProtocolid() {
        return protocolid;
    }

    public void setProtocolid(short protocolid) {
        this.protocolid = protocolid;
    }

    public String getCommaddr() {
        return commaddr;
    }

    public void setCommaddr(String commaddr) {
        this.commaddr = commaddr;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public short getCommContrl() {
        return commContrl;
    }

    public void setCommContrl(short commContrl) {
        this.commContrl = commContrl;
    }

}
