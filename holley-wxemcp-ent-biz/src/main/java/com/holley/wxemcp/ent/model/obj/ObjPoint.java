package com.holley.wxemcp.ent.model.obj;

import java.math.BigDecimal;
import java.util.Date;

public class ObjPoint {
    private Integer pointid;

    private String name;

    private Integer rtuid;

    private Integer ownerid;

    private Short ownertype;

    private Integer eid;

    private Short inputoutput;

    private Short status;

    private Short energytypeid;

    private Short energyprop;

    private Short energyusetypeid;

    private String addr;

    private Short autogather;

    private String sampleinterval;

    private Short dataitemflag;

    private BigDecimal rate;

    private Date ratechangetime;

    private String capability;

    private Short measuremode;

    private Short isprepaid;

    public Integer getPointid() {
        return pointid;
    }

    public void setPointid(Integer pointid) {
        this.pointid = pointid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getRtuid() {
        return rtuid;
    }

    public void setRtuid(Integer rtuid) {
        this.rtuid = rtuid;
    }

    public Integer getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Integer ownerid) {
        this.ownerid = ownerid;
    }

    public Short getOwnertype() {
        return ownertype;
    }

    public void setOwnertype(Short ownertype) {
        this.ownertype = ownertype;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Short getInputoutput() {
        return inputoutput;
    }

    public void setInputoutput(Short inputoutput) {
        this.inputoutput = inputoutput;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getEnergytypeid() {
        return energytypeid;
    }

    public void setEnergytypeid(Short energytypeid) {
        this.energytypeid = energytypeid;
    }

    public Short getEnergyprop() {
        return energyprop;
    }

    public void setEnergyprop(Short energyprop) {
        this.energyprop = energyprop;
    }

    public Short getEnergyusetypeid() {
        return energyusetypeid;
    }

    public void setEnergyusetypeid(Short energyusetypeid) {
        this.energyusetypeid = energyusetypeid;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public Short getAutogather() {
        return autogather;
    }

    public void setAutogather(Short autogather) {
        this.autogather = autogather;
    }

    public String getSampleinterval() {
        return sampleinterval;
    }

    public void setSampleinterval(String sampleinterval) {
        this.sampleinterval = sampleinterval == null ? null : sampleinterval.trim();
    }

    public Short getDataitemflag() {
        return dataitemflag;
    }

    public void setDataitemflag(Short dataitemflag) {
        this.dataitemflag = dataitemflag;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Date getRatechangetime() {
        return ratechangetime;
    }

    public void setRatechangetime(Date ratechangetime) {
        this.ratechangetime = ratechangetime;
    }

    public String getCapability() {
        return capability;
    }

    public void setCapability(String capability) {
        this.capability = capability == null ? null : capability.trim();
    }

    public Short getMeasuremode() {
        return measuremode;
    }

    public void setMeasuremode(Short measuremode) {
        this.measuremode = measuremode;
    }

    public Short getIsprepaid() {
        return isprepaid;
    }

    public void setIsprepaid(Short isprepaid) {
        this.isprepaid = isprepaid;
    }
}