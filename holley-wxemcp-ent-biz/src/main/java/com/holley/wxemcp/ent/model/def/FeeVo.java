package com.holley.wxemcp.ent.model.def;

import java.math.BigDecimal;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.holley.platform.common.util.NumberUtil;

public class FeeVo {

    private Integer    customerid;
    private String     hm;
    private BigDecimal fee;
    private Date       time;
    private BigDecimal usableMoney;
    private Integer    usableDay;

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public String getHm() {
        return hm;
    }

    public void setHm(String hm) {
        this.hm = hm;
    }

    public BigDecimal getFee() {
        return fee == null ? fee : fee.setScale(NumberUtil.DEF_SCALE, NumberUtil.PERCISION);
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * billTime
     * 
     * @return
     */
    public String getBillTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        return formatter.format(time);
    }

    public BigDecimal getUsableMoney() {
        return usableMoney == null ? usableMoney : usableMoney.setScale(NumberUtil.DEF_SCALE, NumberUtil.PERCISION);
    }

    public void setUsableMoney(BigDecimal usableMoney) {
        this.usableMoney = usableMoney;
    }

    public Integer getUsableDay() {
        return usableDay;
    }

    public void setUsableDay(Integer usableDay) {
        this.usableDay = usableDay;
    }

}
