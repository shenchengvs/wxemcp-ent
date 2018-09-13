package com.holley.wxemcp.ent.model.def;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.CompareToBuilder;

import com.holley.platform.common.util.NumberUtil;

public class DepartmentUseDetailsBlock implements Comparable<DepartmentUseDetailsBlock> {

    private double                       nowsum;
    private double                       upratethanla;
    private double                       upratethanlala;
    private double                       lasum;
    private double                       lalasum;
    private String                       name;
    private List<DepartmentUseDetailsVo> ls = new ArrayList<DepartmentUseDetailsVo>();

    public void setLasum(double lasum) {
        this.lasum = lasum;
    }

    public void setLalasum(double lalasum) {
        this.lalasum = lalasum;
    }

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

    public List<DepartmentUseDetailsVo> getLs() {
        return ls;
    }

    public void setLs(List<DepartmentUseDetailsVo> ls) {
        this.ls = ls;
    }

    @Override
    public int compareTo(DepartmentUseDetailsBlock o) {
        // return Double.valueOf(o.getNowsum()).compareTo(this.nowsum);
        return CompareToBuilder.reflectionCompare(o.getNowsum(), this.nowsum);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
