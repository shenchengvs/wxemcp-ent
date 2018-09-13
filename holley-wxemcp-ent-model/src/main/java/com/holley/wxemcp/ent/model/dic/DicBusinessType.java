package com.holley.wxemcp.ent.model.dic;

public class DicBusinessType {
    private Short businesstypeid;

    private String name;

    private Short rank;

    private Short fatherid;

    public Short getBusinesstypeid() {
        return businesstypeid;
    }

    public void setBusinesstypeid(Short businesstypeid) {
        this.businesstypeid = businesstypeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getRank() {
        return rank;
    }

    public void setRank(Short rank) {
        this.rank = rank;
    }

    public Short getFatherid() {
        return fatherid;
    }

    public void setFatherid(Short fatherid) {
        this.fatherid = fatherid;
    }
}