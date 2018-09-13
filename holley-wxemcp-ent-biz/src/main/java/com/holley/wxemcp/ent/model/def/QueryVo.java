package com.holley.wxemcp.ent.model.def;

import java.math.BigDecimal;

import com.holley.platform.common.util.NumberUtil;

public class QueryVo {

    private String     point;
    private BigDecimal startBm;
    private BigDecimal endBm;
    private Integer    multiplyingPower;
    private BigDecimal data;

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public BigDecimal getStartBm() {
        return startBm == null ? startBm : startBm.setScale(NumberUtil.DEF_SCALE, NumberUtil.PERCISION);
    }

    public void setStartBm(BigDecimal startBm) {
        this.startBm = startBm;
    }

    public BigDecimal getEndBm() {
        return endBm == null ? endBm : endBm.setScale(NumberUtil.DEF_SCALE, NumberUtil.PERCISION);
    }

    public void setEndBm(BigDecimal endBm) {
        this.endBm = endBm;
    }

    public Integer getMultiplyingPower() {
        return multiplyingPower;
    }

    public void setMultiplyingPower(Integer multiplyingPower) {
        this.multiplyingPower = multiplyingPower;
    }

    public BigDecimal getData() {
        return data == null ? data : data.setScale(NumberUtil.DEF_SCALE, NumberUtil.PERCISION);
    }

    public void setData(BigDecimal data) {
        this.data = data;
    }
}
