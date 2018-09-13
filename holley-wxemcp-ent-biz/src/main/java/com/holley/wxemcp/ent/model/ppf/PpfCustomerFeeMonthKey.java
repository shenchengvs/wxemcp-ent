package com.holley.wxemcp.ent.model.ppf;

import java.util.Date;

public class PpfCustomerFeeMonthKey {
    private Integer customerid;

    private Date datatime;

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
}