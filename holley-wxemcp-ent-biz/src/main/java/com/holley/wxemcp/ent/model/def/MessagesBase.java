package com.holley.wxemcp.ent.model.def;

import java.util.List;

/**
 * 短信记录
 * 
 * @author sc
 */
public class MessagesBase extends PageBase {

    public MessagesBase(int totalProperty, int pageIndex, int limit) {
        super(totalProperty, pageIndex, limit);
    }

    private int             newRechargeCount;
    private int             newRemoteCount;

    private List<MessageVo> datas;

    public List<MessageVo> getDatas() {
        return datas;
    }

    public void setDatas(List<MessageVo> datas) {
        this.datas = datas;
    }

    public int getNewRechargeCount() {
        return newRechargeCount;
    }

    public void setNewRechargeCount(int newRechargeCount) {
        this.newRechargeCount = newRechargeCount;
    }

    public int getNewRemoteCount() {
        return newRemoteCount;
    }

    public void setNewRemoteCount(int newRemoteCount) {
        this.newRemoteCount = newRemoteCount;
    }

}
