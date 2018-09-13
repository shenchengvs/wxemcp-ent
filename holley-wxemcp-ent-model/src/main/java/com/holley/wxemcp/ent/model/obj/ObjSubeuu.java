package com.holley.wxemcp.ent.model.obj;

public class ObjSubeuu {
    private Integer subeuuid;

    private String name;

    private Integer ownerid;

    private Short ownertype;

    public Integer getSubeuuid() {
        return subeuuid;
    }

    public void setSubeuuid(Integer subeuuid) {
        this.subeuuid = subeuuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Integer ownerid) {
        this.ownerid = ownerid;
    }

    public Short getOwnertype() {
        return ownertype;
    }

    public void setOwnertype(Short ownertype) {
        this.ownertype = ownertype;
    }
}