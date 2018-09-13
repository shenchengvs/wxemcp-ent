package com.holley.wxemcp.ent.model.def;

import java.util.Date;

import com.holley.platform.common.util.DateUtil;
import com.holley.wxemcp.ent.common.constants.CmdTypeEnum;
import com.holley.wxemcp.ent.common.constants.SendMsgTypeEnum;

public class PpfControlCmdVo {

    private String point;
    private Short  cmdtype;
    private Short  operatetype;
    private Date   time;

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getCmdtype() {
        return CmdTypeEnum.getText(cmdtype);
    }

    public void setCmdtype(Short cmdtype) {
        this.cmdtype = cmdtype;
    }

    public String getOperatetype() {
        return SendMsgTypeEnum.getText(operatetype);
    }

    public void setOperatetype(Short operatetype) {
        this.operatetype = operatetype;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDataTime() {
        return DateUtil.DateToLongStr(time);
    }
}
