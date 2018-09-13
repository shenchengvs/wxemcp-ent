package com.holley.wxemcp.ent.model.dic;

import java.math.BigDecimal;

public class DicCity {
    private Short cityid;

    private String name;

    private Short fatherid;

    private Short rank;

    private BigDecimal longitude;

    private BigDecimal latitude;

    public Short getCityid() {
        return cityid;
    }

    public void setCityid(Short cityid) {
        this.cityid = cityid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getFatherid() {
        return fatherid;
    }

    public void setFatherid(Short fatherid) {
        this.fatherid = fatherid;
    }

    public Short getRank() {
        return rank;
    }

    public void setRank(Short rank) {
        this.rank = rank;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }
}