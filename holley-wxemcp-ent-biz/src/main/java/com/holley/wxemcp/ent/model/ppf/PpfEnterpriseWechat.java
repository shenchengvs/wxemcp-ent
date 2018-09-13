package com.holley.wxemcp.ent.model.ppf;

import java.util.Date;

public class PpfEnterpriseWechat {
    private String openId;

    private Integer enterpriseId;

    private String account;

    private Short loginStatus;

    private Short pushStatus;

    private Date updateTime;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Short getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Short loginStatus) {
        this.loginStatus = loginStatus;
    }

    public Short getPushStatus() {
        return pushStatus;
    }

    public void setPushStatus(Short pushStatus) {
        this.pushStatus = pushStatus;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}