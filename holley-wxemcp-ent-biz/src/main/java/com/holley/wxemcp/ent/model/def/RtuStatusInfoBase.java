package com.holley.wxemcp.ent.model.def;

import java.util.List;

public class RtuStatusInfoBase extends PageBase {

    public RtuStatusInfoBase(int totalProperty, int pageIndex, int limit) {
        super(totalProperty, pageIndex, limit);
    }

    private List<RtuStatusInfoVo> datas;

    public List<RtuStatusInfoVo> getDatas() {
        return datas;
    }

    public void setDatas(List<RtuStatusInfoVo> datas) {
        this.datas = datas;
    }

}
