package com.holley.wxemcp.ent.model.dat;

import java.util.Date;

public class DatStaEnergyKey {
    private Short circletypeid;

    private Date datatime;

    private Integer objid;

    private Short objtype;

    private Short tarriftypeid;

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

    public Short getTarriftypeid() {
        return tarriftypeid;
    }

    public void setTarriftypeid(Short tarriftypeid) {
        this.tarriftypeid = tarriftypeid;
    }
}