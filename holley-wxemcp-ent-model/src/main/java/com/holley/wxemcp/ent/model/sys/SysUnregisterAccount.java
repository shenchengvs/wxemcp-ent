package com.holley.wxemcp.ent.model.sys;

import java.util.Date;

public class SysUnregisterAccount {
    private String phone;

    private Short origin;

    private Integer codecount;

    private Integer logincount;

    private Date updatetime;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Short getOrigin() {
        return origin;
    }

    public void setOrigin(Short origin) {
        this.origin = origin;
    }

    public Integer getCodecount() {
        return codecount;
    }

    public void setCodecount(Integer codecount) {
        this.codecount = codecount;
    }

    public Integer getLogincount() {
        return logincount;
    }

    public void setLogincount(Integer logincount) {
        this.logincount = logincount;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}