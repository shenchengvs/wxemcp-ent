package com.holley.wxemcp.ent.model.def;

import java.util.Date;

import com.holley.platform.common.util.DateUtil;
import com.holley.wxemcp.ent.common.constants.EventTypeEnum;

public class EventDetailVo {

    // com
    private Short  type;
    private String eventContent;
    private Date   eventTime;
    // record
    private Short  recEventType;
    // his
    private Short  hisEvenStatus;
    private String hisEventNote;

    public String getEventContent() {
        return eventContent;
    }

    public void setEventContent(String eventContent) {
        this.eventContent = eventContent;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public Short getRecEventType() {
        return recEventType;
    }

    public void setRecEventType(Short recEventType) {
        this.recEventType = recEventType;
    }

    public Short getHisEvenStatus() {
        return hisEvenStatus;
    }

    public void setHisEvenStatus(Short hisEvenStatus) {
        this.hisEvenStatus = hisEvenStatus;
    }

    public String getHisEventNote() {
        return hisEventNote;
    }

    public void setHisEventNote(String hisEventNote) {
        this.hisEventNote = hisEventNote;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getEventNote() {
        if (type == 1) {
            return EventTypeEnum.getText(type);
        } else if (type == 2) {
            return hisEventNote;
        }
        return "--";
    }

    public String getEventTimeStr() {
        return DateUtil.DateToLongStr(eventTime);
    }
}
