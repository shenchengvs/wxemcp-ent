package com.holley.wxemcp.ent.model.def;

import java.math.BigDecimal;
import java.util.List;

import com.holley.platform.common.util.NumberUtil;

public class EnergyUseDetailsBlock {

    private double                   nowsum;
    private double                   upratethanla;
    private double                   upratethanlala;
    private double                   lasum;
    private double                   lalasum;
    private String                   name;
    private List<EnergyUseDetailsVo> ls;

    public double getNowsum() {
        return nowsum;
    }

    public void setNowsum(double nowsum) {
        this.nowsum = nowsum;
    }

    public double getUpratethanla() {
        if (nowsum > 0 && lasum > 0) {
            double value = (nowsum - lasum) / lasum;
            value = value > 0 ? value : 0;
            value = new BigDecimal(value * 100).setScale(NumberUtil.DEF_SCALE, NumberUtil.PERCISION).doubleValue();
            return value;
        }
        return 0;
    }

    public void setUpratethanla(double upratethanla) {
        this.upratethanla = upratethanla;
    }

    public double getUpratethanlala() {
        if (nowsum > 0 && lalasum > 0) {
            double value = (nowsum - lalasum) / lalasum;
            value = value > 0 ? value : 0;
            value = new BigDecimal(value * 100).setScale(NumberUtil.DEF_SCALE, NumberUtil.PERCISION).doubleValue();
            return value;
        }
        return 0;
    }

    public void setUpratethanlala(double upratethanlala) {
        this.upratethanlala = upratethanlala;
    }

    public void setLasum(double lasum) {
        this.lasum = lasum;
    }

    public void setLalasum(double lalasum) {
        this.lalasum = lalasum;
    }

    public List<EnergyUseDetailsVo> getLs() {
        return ls;
    }

    public void setLs(List<EnergyUseDetailsVo> ls) {
        this.ls = ls;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
