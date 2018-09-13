package com.holley.wxemcp.ent.model.ppf;

import java.util.Date;

public class EvtRecord extends EvtRecordKey {
    private Short eventtype;

    private Date sendtime;

    private String eventdesc;

    private Integer eid;

    public Short getEventtype() {
        return eventtype;
    }

    public void setEventtype(Short eventtype) {
        this.eventtype = eventtype;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public String getEventdesc() {
        return eventdesc;
    }

    public void setEventdesc(String eventdesc) {
        this.eventdesc = eventdesc == null ? null : eventdesc.trim();
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }
}