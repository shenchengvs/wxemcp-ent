package com.holley.wxemcp.ent.model.def;

import java.util.Date;

import com.holley.platform.common.util.DateUtil;
import com.holley.wxemcp.ent.common.constants.SendMsgTypeEnum;
import com.holley.wxemcp.ent.common.constants.SmsTypeEnum;

public class MessageVo {

    private String  hm;
    private String  phone;
    private Integer msgType;
    private Integer sendType;
    private Date    time;

    public String getHm() {
        return hm;
    }

    public void setHm(String hm) {
        this.hm = hm;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public String getMsgTypeDesc() {
        return SmsTypeEnum.getText(msgType);
    }

    public String getSendTypeDesc() {
        return SendMsgTypeEnum.getText(sendType);
    }

    public Integer getSendType() {
        return sendType;
    }

    public void setSendType(Integer sendType) {
        this.sendType = sendType;
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
