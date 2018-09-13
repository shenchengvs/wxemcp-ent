package com.holley.wxemcp.ent.model.def;

import java.util.Date;

import com.holley.platform.common.util.DateUtil;
import com.holley.wxemcp.ent.common.constants.ObjectTypeEnum;

public class EvtWxSendVo {

    private Date    eventTime;
    private String  name;
    private Integer objId;
    private Short   objType;
    private String  eventNote;
    private Short   status;
    private Short   eventItemId;

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getObjType() {
        return objType;
    }

    public void setObjType(Short objType) {
        this.objType = objType;
    }

    public String getEventNote() {
        return eventNote;
    }

    public void setEventNote(String eventNote) {
        this.eventNote = eventNote;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getEventTimeStr() {
        return DateUtil.DateToLongStr(eventTime);
    }

    public Integer getObjId() {
        return objId;
    }

    public void setObjId(Integer objId) {
        this.objId = objId;
    }

    public Short getEventItemId() {
        return eventItemId;
    }

    public void setEventItemId(Short eventItemId) {
        this.eventItemId = eventItemId;
    }

    public String getEventContent() {
        if (ObjectTypeEnum.OBJ_POINT.getShortValue() == objType) {
            return "计量点【" + name + "】 " + eventNote;
        } else if (ObjectTypeEnum.OBJ_RTU.getShortValue() == objType) {
            return "终端【" + name + "】 " + eventNote;
        }
        return "";
    }
}
