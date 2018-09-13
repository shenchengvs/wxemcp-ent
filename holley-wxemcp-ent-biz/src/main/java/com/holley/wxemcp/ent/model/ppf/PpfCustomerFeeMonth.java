package com.holley.wxemcp.ent.model.ppf;

import java.math.BigDecimal;
import java.util.Date;

public class PpfCustomerFeeMonth extends PpfCustomerFeeMonthKey {
    private BigDecimal actualfee;

    private BigDecimal fee;

    private BigDecimal basefee;

    private BigDecimal fundfee;

    private BigDecimal pffee;

    private Short status;

    private BigDecimal usablemoney;

    private Date addtime;

    private Date billtime;

    public BigDecimal getActualfee() {
        return actualfee;
    }

    public void setActualfee(BigDecimal actualfee) {
        this.actualfee = actualfee;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getBasefee() {
        return basefee;
    }

    public void setBasefee(BigDecimal basefee) {
        this.basefee = basefee;
    }

    public BigDecimal getFundfee() {
        return fundfee;
    }

    public void setFundfee(BigDecimal fundfee) {
        this.fundfee = fundfee;
    }

    public BigDecimal getPffee() {
        return pffee;
    }

    public void setPffee(BigDecimal pffee) {
        this.pffee = pffee;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public BigDecimal getUsablemoney() {
        return usablemoney;
    }

    public void setUsablemoney(BigDecimal usablemoney) {
        this.usablemoney = usablemoney;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Date getBilltime() {
        return billtime;
    }

    public void setBilltime(Date billtime) {
        this.billtime = billtime;
    }
}