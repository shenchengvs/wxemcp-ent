package com.holley.wxemcp.ent.model.ppf;

import java.util.Date;

public class DatStaItemUsedKey {
    private Short circletypeid;

    private Date datatime;

    private Short energytype;

    private Short energyuse;

    private Integer objid;

    private Short objtype;

    public Short getCircletypeid() {
        return circletypeid;
    }

    public void setCircletypeid(Short circletypeid) {
        this.circletypeid = circletypeid;
    }

    public Date getDatatime() {
        return datatime;
    }

    public void setDatatime(Date datatime) {
        this.datatime = datatime;
    }

    public Short getEnergytype() {
        return energytype;
    }

    public void setEnergytype(Short energytype) {
        this.energytype = energytype;
    }

    public Short getEnergyuse() {
        return energyuse;
    }

    public void setEnergyuse(Short energyuse) {
        this.energyuse = energyuse;
    }

    public Integer getObjid() {
        return objid;
    }

    public void setObjid(Integer objid) {
        this.objid = objid;
    }

    public Short getObjtype() {
        return objtype;
    }

    public void setObjtype(Short objtype) {
        this.objtype = objtype;
    }
}