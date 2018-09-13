package com.holley.wxemcp.ent.model.ppf;

import java.math.BigDecimal;
import java.util.Date;

import com.holley.wxemcp.ent.common.constants.PayWayTypeEnum;

public class PpfRecharge {
    private Integer rechargeid;

    private Integer customerid;

    private BigDecimal payMoney;

    private BigDecimal actualMoney;

    private Date addtime;

    private String account;

    private Short status;

    private Short payway;

    private String tradeno;

    private BigDecimal usablemoney;

    public Integer getRechargeid() {
        return rechargeid;
    }

    public void setRechargeid(Integer rechargeid) {
        this.rechargeid = rechargeid;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public BigDecimal getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    public BigDecimal getActualMoney() {
        return actualMoney;
    }

    public void setActualMoney(BigDecimal actualMoney) {
        this.actualMoney = actualMoney;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getPayway() {
        return PayWayTypeEnum.getText(payway);
    }

    public void setPayway(Short payway) {
        this.payway = payway;
    }

    public String getTradeno() {
        return tradeno;
    }

    public void setTradeno(String tradeno) {
        this.tradeno = tradeno == null ? null : tradeno.trim();
    }

    public BigDecimal getUsablemoney() {
        return usablemoney;
    }

    public void setUsablemoney(BigDecimal usablemoney) {
        this.usablemoney = usablemoney;
    }
}