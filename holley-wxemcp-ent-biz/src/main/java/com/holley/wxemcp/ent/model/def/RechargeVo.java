package com.holley.wxemcp.ent.model.def;

import com.holley.platform.common.util.DateUtil;
import com.holley.wxemcp.ent.model.ppf.PpfRecharge;

public class RechargeVo extends PpfRecharge {

    private String hm;

    public String getHm() {
        return hm;
    }

    public void setHm(String hm) {
        this.hm = hm;
    }

    public String getPaywayDesc() {
        return super.getPayway();
    }

    public String getDataTime() {
        return DateUtil.DateToLongStr(getAddtime());
    }
}
