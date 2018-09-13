package com.holley.wxemcp.ent.model.def;

import java.util.List;

public class ElectricalConsumptionBlock {

    private double                             nowsum;
    private double                             upratethanla;
    private double                             upratethanlala;
    private List<ElectricalConsumptionBlockVo> ls;

    public double getNowsum() {
        return nowsum;
    }

    public void setNowsum(double nowsum) {
        this.nowsum = nowsum;
    }

    public double getUpratethanla() {
        return upratethanla;
    }

    public void setUpratethanla(double upratethanla) {
        this.upratethanla = upratethanla;
    }

    public double getUpratethanlala() {
        return upratethanlala;
    }

    public void setUpratethanlala(double upratethanlala) {
        this.upratethanlala = upratethanlala;
    }

    public List<ElectricalConsumptionBlockVo> getLs() {
        return ls;
    }

    public void setLs(List<ElectricalConsumptionBlockVo> ls) {
        this.ls = ls;
    }

}
