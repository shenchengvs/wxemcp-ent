package com.holley.wxemcp.ent.model.def;

import java.util.List;

public class CuiFeiCountBlock {

    private Integer             nowcount;
    private double              upratethanla;
    private double              upratethanlala;
    private List<CuiFeiCountVo> ls;

    public Integer getNowcount() {
        return nowcount;
    }

    public void setNowcount(Integer nowcount) {
        this.nowcount = nowcount;
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

    public List<CuiFeiCountVo> getLs() {
        return ls;
    }

    public void setLs(List<CuiFeiCountVo> ls) {
        this.ls = ls;
    }

}
