package com.holley.wxemcp.ent.model.def;

import java.util.Date;

import com.holley.platform.common.util.DateUtil;
import com.holley.wxemcp.ent.common.constants.RtuStatusEnum;

public class RtuStatusInfoVo {

    private String name;
    private String commaddr;
    private Date   onlineTime;
    private Short  status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(Date onlineTime) {
        this.onlineTime = onlineTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getOnlineTimeDesc() {
        return DateUtil.DateToLongStr(onlineTime);
    }

    public String getStatusDesc() {
        return RtuStatusEnum.getText(status);
    }

    public String getCommaddr() {
        return commaddr;
    }

    public void setCommaddr(String commaddr) {
        this.commaddr = commaddr;
    }

}
