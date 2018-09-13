package com.holley.wxemcp.ent.model.ppf;

import java.util.Date;

public class EvtRecordKey {
    private Integer eventparamid;

    private Integer objid;

    private Integer objtype;

    private Date occurtime;

    public Integer getEventparamid() {
        return eventparamid;
    }

    public void setEventparamid(Integer eventparamid) {
        this.eventparamid = eventparamid;
    }

    public Integer getObjid() {
        return objid;
    }

    public void setObjid(Integer objid) {
        this.objid = objid;
    }

    public Integer getObjtype() {
        return objtype;
    }

    public void setObjtype(Integer objtype) {
        this.objtype = objtype;
    }

    public Date getOccurtime() {
        return occurtime;
    }

    public void setOccurtime(Date occurtime) {
        this.occurtime = occurtime;
    }
}