package com.holley.wxemcp.ent.model.def;

public abstract class ExtendPowerBmEid {

    public final static String  EXTEND_EID = "extendEid";
    public final static boolean IS_USED    = false;
    private Integer             extendEid;

    public Integer getExtendEid() {
        return extendEid;
    }

    public void setExtendEid(Integer extendEid) {
        this.extendEid = extendEid;
    }

}
