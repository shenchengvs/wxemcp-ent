package com.holley.wxemcp.ent.model.ppf;

import java.math.BigDecimal;
import java.util.Date;

public class PpfCustomerAccount {
    private Integer customerid;

    private Short status;

    private BigDecimal totalmoney;

    private BigDecimal usablemoney;

    private BigDecimal freezemoney;

    private BigDecimal freezemoney2;

    private Date billdate;

    private Date billdate2;

    private Date updatetime;

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public BigDecimal getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(BigDecimal totalmoney) {
        this.totalmoney = totalmoney;
    }

    public BigDecimal getUsablemoney() {
        return usablemoney;
    }

    public void setUsablemoney(BigDecimal usablemoney) {
        this.usablemoney = usablemoney;
    }

    public BigDecimal getFreezemoney() {
        return freezemoney;
    }

    public void setFreezemoney(BigDecimal freezemoney) {
        this.freezemoney = freezemoney;
    }

    public BigDecimal getFreezemoney2() {
        return freezemoney2;
    }

    public void setFreezemoney2(BigDecimal freezemoney2) {
        this.freezemoney2 = freezemoney2;
    }

    public Date getBilldate() {
        return billdate;
    }

    public void setBilldate(Date billdate) {
        this.billdate = billdate;
    }

    public Date getBilldate2() {
        return billdate2;
    }

    public void setBilldate2(Date billdate2) {
        this.billdate2 = billdate2;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}