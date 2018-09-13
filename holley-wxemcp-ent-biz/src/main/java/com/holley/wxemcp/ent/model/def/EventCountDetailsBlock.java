package com.holley.wxemcp.ent.model.def;

public class EventCountDetailsBlock {

    private RechargeCountBlock RechargeCountBlock;
    private LaZhaCountBlock    LaZhaCountBlock;
    private CuiFeiCountBlock   CuiFeiCountBlock;

    public RechargeCountBlock getRechargeCountBlock() {
        return RechargeCountBlock;
    }

    public void setRechargeCountBlock(RechargeCountBlock rechargeCountBlock) {
        RechargeCountBlock = rechargeCountBlock;
    }

    public LaZhaCountBlock getLaZhaCountBlock() {
        return LaZhaCountBlock;
    }

    public void setLaZhaCountBlock(LaZhaCountBlock laZhaCountBlock) {
        LaZhaCountBlock = laZhaCountBlock;
    }

    public CuiFeiCountBlock getCuiFeiCountBlock() {
        return CuiFeiCountBlock;
    }

    public void setCuiFeiCountBlock(CuiFeiCountBlock cuiFeiCountBlock) {
        CuiFeiCountBlock = cuiFeiCountBlock;
    }

}
