package com.holley.wxemcp.ent.model.def;

import java.math.BigDecimal;

import com.holley.platform.common.util.NumberUtil;

public class EnergyUserBlockVo {

    private String name;
    private double baifenshu;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaifenshu() {
        // return baifenshu;
        return new BigDecimal(baifenshu * 100).setScale(NumberUtil.DEF_SCALE, NumberUtil.PERCISION).doubleValue();
    }

    public void setBaifenshu(double baifenshu) {
        this.baifenshu = baifenshu;
    }

}
