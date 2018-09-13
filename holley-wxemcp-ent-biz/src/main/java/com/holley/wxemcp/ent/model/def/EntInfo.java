package com.holley.wxemcp.ent.model.def;

import com.holley.platform.model.def.EntBaseInfo;

public class EntInfo extends EntBaseInfo {

    private static final long serialVersionUID = 1L;
    private Short             city;
    private String            cityname;

    public Short getCity() {
        return city;
    }

    public void setCity(Short city) {
        this.city = city;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

}
