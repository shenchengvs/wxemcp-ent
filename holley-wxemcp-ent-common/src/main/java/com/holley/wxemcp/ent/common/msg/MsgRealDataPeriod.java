package com.holley.wxemcp.ent.common.msg;

/**
 * 实时数据上报/存储周期
 * 
 * @author zdd
 */
public class MsgRealDataPeriod extends MsgBase {

    long period;// 秒

    public long getPeriod() {
        return period;
    }

    public void setPeriod(long period) {
        this.period = period;
    }

}
