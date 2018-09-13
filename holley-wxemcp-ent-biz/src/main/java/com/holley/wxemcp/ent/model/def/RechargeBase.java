package com.holley.wxemcp.ent.model.def;

import java.util.List;

public class RechargeBase extends PageBase {

    private List<RechargeVo> datas;
    private int              newRemoteCount;
    private int              newMessageCount;

    public RechargeBase(int totalProperty, int pageIndex, int limit) {
        super(totalProperty, pageIndex, limit);
    }

    public List<RechargeVo> getDatas() {
        return datas;
    }

    public void setDatas(List<RechargeVo> datas) {
        this.datas = datas;
    }

    public int getNewRemoteCount() {
        return newRemoteCount;
    }

    public void setNewRemoteCount(int newRemoteCount) {
        this.newRemoteCount = newRemoteCount;
    }

    public int getNewMessageCount() {
        return newMessageCount;
    }

    public void setNewMessageCount(int newMessageCount) {
        this.newMessageCount = newMessageCount;
    }

}
