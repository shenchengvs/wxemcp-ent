package com.holley.wxemcp.ent.model.def;

public class WxSendEventId {

    private Integer delayTime;
    private Integer assistanId; // 副事件ID

    public WxSendEventId(Integer assistanId, Integer delayTime) {
        this.assistanId = assistanId;
        this.delayTime = delayTime;
    }

    public Integer getAssistanId() {
        return assistanId;
    }

    public void setAssistanId(Integer assistanId) {
        this.assistanId = assistanId;
    }

    public Integer getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(Integer delayTime) {
        this.delayTime = delayTime;
    }

}
