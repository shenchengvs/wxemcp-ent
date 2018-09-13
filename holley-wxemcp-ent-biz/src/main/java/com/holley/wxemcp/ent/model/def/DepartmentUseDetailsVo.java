package com.holley.wxemcp.ent.model.def;

import java.util.Date;

import org.apache.commons.lang3.builder.CompareToBuilder;

public class DepartmentUseDetailsVo implements Comparable<DepartmentUseDetailsVo> {

    private int    objid;
    private Date   datatime;
    private double energy;
    private String name;
    private String datename;

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

    public int getObjid() {
        return objid;
    }

    public void setObjid(int objid) {
        this.objid = objid;
    }

    public Date getDatatime() {
        return datatime;
    }

    public void setDatatime(Date datatime) {
        this.datatime = datatime;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    @Override
    public int compareTo(DepartmentUseDetailsVo o) {
        return CompareToBuilder.reflectionCompare(o.getDatename(), this.datename);
    }
}
