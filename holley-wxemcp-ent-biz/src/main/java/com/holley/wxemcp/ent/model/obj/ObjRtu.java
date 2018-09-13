package com.holley.wxemcp.ent.model.obj;

import java.util.Date;

public class ObjRtu {
    private Integer rtuid;

    private String code;

    private String name;

    private Integer euuid;

    private String commaddr;

    private Short protocolid;

    private Integer schemeid;

    private Short channelid1;

    private String ip;

    private Integer port;

    private String rtuip;

    private Short channelid2;

    private Short readschemeid;

    private String model;

    private Short qtid;

    private String password1;

    private String password2;

    private Short factoryid;

    private Date installtime;

    private String address;

    private Short registetype;

    public Integer getRtuid() {
        return rtuid;
    }

    public void setRtuid(Integer rtuid) {
        this.rtuid = rtuid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getEuuid() {
        return euuid;
    }

    public void setEuuid(Integer euuid) {
        this.euuid = euuid;
    }

    public String getCommaddr() {
        return commaddr;
    }

    public void setCommaddr(String commaddr) {
        this.commaddr = commaddr == null ? null : commaddr.trim();
    }

    public Short getProtocolid() {
        return protocolid;
    }

    public void setProtocolid(Short protocolid) {
        this.protocolid = protocolid;
    }

    public Integer getSchemeid() {
        return schemeid;
    }

    public void setSchemeid(Integer schemeid) {
        this.schemeid = schemeid;
    }

    public Short getChannelid1() {
        return channelid1;
    }

    public void setChannelid1(Short channelid1) {
        this.channelid1 = channelid1;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getRtuip() {
        return rtuip;
    }

    public void setRtuip(String rtuip) {
        this.rtuip = rtuip == null ? null : rtuip.trim();
    }

    public Short getChannelid2() {
        return channelid2;
    }

    public void setChannelid2(Short channelid2) {
        this.channelid2 = channelid2;
    }

    public Short getReadschemeid() {
        return readschemeid;
    }

    public void setReadschemeid(Short readschemeid) {
        this.readschemeid = readschemeid;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public Short getQtid() {
        return qtid;
    }

    public void setQtid(Short qtid) {
        this.qtid = qtid;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1 == null ? null : password1.trim();
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2 == null ? null : password2.trim();
    }

    public Short getFactoryid() {
        return factoryid;
    }

    public void setFactoryid(Short factoryid) {
        this.factoryid = factoryid;
    }

    public Date getInstalltime() {
        return installtime;
    }

    public void setInstalltime(Date installtime) {
        this.installtime = installtime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Short getRegistetype() {
        return registetype;
    }

    public void setRegistetype(Short registetype) {
        this.registetype = registetype;
    }
}