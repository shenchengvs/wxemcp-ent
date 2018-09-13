package com.holley.wxemcp.ent.model.ppf;

import java.util.Date;

public class PpfControlCmdKey {
    private Date cmdtime;

    private Integer pointid;

    public Date getCmdtime() {
        return cmdtime;
    }

    public void setCmdtime(Date cmdtime) {
        this.cmdtime = cmdtime;
    }

    public Integer getPointid() {
        return pointid;
    }

    public void setPointid(Integer pointid) {
        this.pointid = pointid;
    }
}