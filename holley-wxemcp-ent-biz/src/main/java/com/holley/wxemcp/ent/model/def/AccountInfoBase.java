package com.holley.wxemcp.ent.model.def;

public class AccountInfoBase {

    private String account;
    private String entName;
    private String phone;
    private int    isShow;  // 是否显示1.是2.否
    private int    isPush;  // 是否推送1.是2.否

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIsShow() {
        return isShow;
    }

    public void setIsShow(int isShow) {
        this.isShow = isShow;
    }

    public int getIsPush() {
        return isPush;
    }

    public void setIsPush(int isPush) {
        this.isPush = isPush;
    }

}
