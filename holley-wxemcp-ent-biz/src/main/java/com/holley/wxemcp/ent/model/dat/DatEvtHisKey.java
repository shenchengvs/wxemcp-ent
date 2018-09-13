package com.holley.wxemcp.ent.model.dat;

import java.util.Date;

public class DatEvtHisKey {
    private Short eventitemid;

    private Date eventtime;

    private Integer objid;

    private Short objtype;

    private Short status;

    public Short getEventitemid() {
        return eventitemid;
    }

    public void setEventitemid(Short eventitemid) {
        this.eventitemid = eventitemid;
    }

    public Date getEventtime() {
        return eventtime;
    }

    public void setEventtime(Date eventtime) {
        this.eventtime = eventtime;
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

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }
}