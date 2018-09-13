package com.holley.wxemcp.ent.model.def;

import java.util.Date;

import org.apache.commons.lang3.builder.CompareToBuilder;

public class EnergyUseDetailsVo implements Comparable<EnergyUseDetailsVo> {

    private int    id;
    private double energy;
    private Date   datatime;

    private String datename;
    private String name;

    public Date getDatatime() {
        return datatime;
    }

    public void setDatatime(Date datatime) {
        this.datatime = datatime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public String getDatename() {
        return datename;
    }

    public void setDatename(String datename) {
        this.datename = datename;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(EnergyUseDetailsVo o) {
        return CompareToBuilder.reflectionCompare(o.getDatename(), this.datename);
    }
}
