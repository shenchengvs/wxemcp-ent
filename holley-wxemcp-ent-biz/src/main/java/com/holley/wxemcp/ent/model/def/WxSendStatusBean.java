package com.holley.wxemcp.ent.model.def;

import java.util.Date;

public class WxSendStatusBean {

    private Integer eid;          // 企业id
    private Short   objType;      // 设备类型
    private Integer objId;        // 设备ID
    private Integer principalId;  // 主事件ID
    private Date    principalDate; // 主事件最新时间
    private Integer assistantId;  // 副事件ID
    private Date    assistantDate; // 副事件最新时间

    private Date    sendDate;      // 发送时间

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Date getPrincipalDate() {
        return principalDate;
    }

    public void setPrincipalDate(Date principalDate) {
        this.principalDate = principalDate;
    }

    public Short getObjType() {
        return objType;
    }

    public void setObjType(Short objType) {
        this.objType = objType;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Date getAssistantDate() {
        return assistantDate;
    }

    public void setAssistantDate(Date assistantDate) {
        this.assistantDate = assistantDate;
    }

    public Integer getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(Integer principalId) {
        this.principalId = principalId;
    }

    public Integer getAssistantId() {
        return assistantId;
    }

    public void setAssistantId(Integer assistantId) {
        this.assistantId = assistantId;
    }

    public Integer getObjId() {
        return objId;
    }

    public void setObjId(Integer objId) {
        this.objId = objId;
    }

}
