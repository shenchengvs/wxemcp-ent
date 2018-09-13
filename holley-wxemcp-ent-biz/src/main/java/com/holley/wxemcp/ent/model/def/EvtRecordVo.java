package com.holley.wxemcp.ent.model.def;

import java.util.Date;

import com.holley.platform.common.util.DateUtil;

public class EvtRecordVo {

    private String  eventDesc;
    private Date    time;
    // ADD
    private Short   type;        // 1:record 2:his
    private Integer objid;        // 1:record 2:his
    private Short   objtype;      // 1:record 2:his
    // ADD evt_record
    private Integer eventparamid; // 1:record
    private Date    occurtime;   // 1:record

    // ADD dat_evt_his
    private Date    eventtime;   // 2:his
    private Short   eventitemid; // 2:his
    private Short   status;      // 2:his

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public String getDataTime() {
        return DateUtil.DateToLongStr(time);
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
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

    public Integer getEventparamid() {
        return eventparamid;
    }

    public void setEventparamid(Integer eventparamid) {
        this.eventparamid = eventparamid;
    }

    public Date getOccurtime() {
        return occurtime;
    }

    public void setOccurtime(Date occurtime) {
        this.occurtime = occurtime;
    }

    public Date getEventtime() {
        return eventtime;
    }

    public void setEventtime(Date eventtime) {
        this.eventtime = eventtime;
    }

    public Short getEventitemid() {
        return eventitemid;
    }

    public void setEventitemid(Short eventitemid) {
        this.eventitemid = eventitemid;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getOccurtimeStr() {
        return DateUtil.DateToLongStr(occurtime);
    }

    public String getEventtimeStr() {
        return DateUtil.DateToLongStr(eventtime);
    }
}
