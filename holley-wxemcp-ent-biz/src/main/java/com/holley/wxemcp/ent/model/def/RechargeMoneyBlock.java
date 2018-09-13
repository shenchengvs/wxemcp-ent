package com.holley.wxemcp.ent.model.def;

import java.util.List;

public class RechargeMoneyBlock {

    private double                nowRechargeMoney;
    private double                upRateThanLa;
    private double                upRateThanLaLa;
    private List<RechargeMoneyVo> ls;

    public double getNowRechargeMoney() {
        return nowRechargeMoney;
    }

    public void setNowRechargeMoney(double nowRechargeMoney) {
        this.nowRechargeMoney = nowRechargeMoney;
    }

    public double getUpRateThanLa() {
        return upRateThanLa;
    }

    public void setUpRateThanLa(double upRateThanLa) {
        this.upRateThanLa = upRateThanLa;
    }

    public double getUpRateThanLaLa() {
        return upRateThanLaLa;
    }

    public void setUpRateThanLaLa(double upRateThanLaLa) {
        this.upRateThanLaLa = upRateThanLaLa;
    }

    public List<RechargeMoneyVo> getLs() {
        return ls;
    }

    public void setLs(List<RechargeMoneyVo> ls) {
        this.ls = ls;
    }

}
