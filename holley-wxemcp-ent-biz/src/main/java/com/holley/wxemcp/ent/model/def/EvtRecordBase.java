package com.holley.wxemcp.ent.model.def;

import java.util.List;

public class EvtRecordBase extends PageBase {

    public EvtRecordBase(int totalProperty, int pageIndex, int limit) {
        super(totalProperty, pageIndex, limit);
        // TODO Auto-generated constructor stub
    }

    private List<EvtRecordVo> datas;

    public List<EvtRecordVo> getDatas() {
        return datas;
    }

    public void setDatas(List<EvtRecordVo> datas) {
        this.datas = datas;
    }

    public Integer getYesterdayCount() {
        return yesterdayCount;
    }

    public void setYesterdayCount(Integer yesterdayCount) {
        this.yesterdayCount = yesterdayCount;
    }

    public Integer getTodayCount() {
        return todayCount;
    }

    public void setTodayCount(Integer todayCount) {
        this.todayCount = todayCount;
    }

    private Integer yesterdayCount;
    private Integer todayCount;
}
