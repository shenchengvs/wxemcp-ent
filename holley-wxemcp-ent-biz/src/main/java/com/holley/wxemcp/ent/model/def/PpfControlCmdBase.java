package com.holley.wxemcp.ent.model.def;

import java.util.List;

public class PpfControlCmdBase extends PageBase {

    public PpfControlCmdBase(int totalProperty, int pageIndex, int limit) {
        super(totalProperty, pageIndex, limit);
    }

    private int                   newMessageCount;
    private int                   newRechargeCount;
    private List<PpfControlCmdVo> datas;

    public List<PpfControlCmdVo> getDatas() {
        return datas;
    }

    public void setDatas(List<PpfControlCmdVo> datas) {
        this.datas = datas;
    }

    public int getNewMessageCount() {
        return newMessageCount;
    }

    public void setNewMessageCount(int newMessageCount) {
        this.newMessageCount = newMessageCount;
    }

    public int getNewRechargeCount() {
        return newRechargeCount;
    }

    public void setNewRechargeCount(int newRechargeCount) {
        this.newRechargeCount = newRechargeCount;
    }

}
