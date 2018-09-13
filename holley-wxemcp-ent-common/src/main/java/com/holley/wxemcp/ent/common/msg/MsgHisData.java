package com.holley.wxemcp.ent.common.msg;

import java.util.Calendar;

public class MsgHisData extends MsgBase {

    Calendar startTime;
    Calendar endTime;

    public Calendar getStartTime() {
        return startTime;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }

}
