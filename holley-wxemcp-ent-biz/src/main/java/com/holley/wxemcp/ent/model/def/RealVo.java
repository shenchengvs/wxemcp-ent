package com.holley.wxemcp.ent.model.def;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.holley.platform.common.util.NumberUtil;

public class RealVo {

    private String     point;
    private BigDecimal data;
    private Date       time;     // 原始数据
    private String     ownername;

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public BigDecimal getData() {
        return data == null ? data : data.setScale(NumberUtil.DEF_SCALE, NumberUtil.PERCISION);
    }

    public void setData(BigDecimal data) {
        this.data = data;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    /**
     * dataTime
     * 
     * @return
     */
    public String getDataTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(time);
    }
}
