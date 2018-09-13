package com.holley.wxemcp.ent.model.ppf;

import java.util.Date;

public class PpfCustomerFeeMonthOtherKey {
    private Integer customerid;

    private Date datatime;

    private Short energytype;

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public Date getDatatime() {
        return datatime;
    }

    public void setDatatime(Date datatime) {
        this.datatime = datatime;
    }

    public Short getEnergytype() {
        return energytype;
    }

    public void setEnergytype(Short energytype) {
        this.energytype = energytype;
    }
}