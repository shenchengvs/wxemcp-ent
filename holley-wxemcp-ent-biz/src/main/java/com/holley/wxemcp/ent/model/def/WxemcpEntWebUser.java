package com.holley.wxemcp.ent.model.def;

public class WxemcpEntWebUser {

    private String  account;  // 用户Id
    private Short   entType;  // 用户企业类型
    private Integer entId;    // 用户Id
    private Short   loginType; // 用户类型

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Short getEntType() {
        return entType;
    }

    public void setEntType(Short entType) {
        this.entType = entType;
    }

    public Integer getEntId() {
        return entId;
    }

    public void setEntId(Integer entId) {
        this.entId = entId;
    }

    public Short getLoginType() {
        return loginType;
    }

    public void setLoginType(Short loginType) {
        this.loginType = loginType;
    }

}
