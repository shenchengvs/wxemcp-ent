package com.holley.wxemcp.ent.model.dat;

import java.util.Date;

public class DatEvtHis extends DatEvtHisKey {
    private String eventnote;

    private String eventdata;

    private Date updatetime;

    public String getEventnote() {
        return eventnote;
    }

    public void setEventnote(String eventnote) {
        this.eventnote = eventnote == null ? null : eventnote.trim();
    }

    public String getEventdata() {
        return eventdata;
    }

    public void setEventdata(String eventdata) {
        this.eventdata = eventdata == null ? null : eventdata.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}