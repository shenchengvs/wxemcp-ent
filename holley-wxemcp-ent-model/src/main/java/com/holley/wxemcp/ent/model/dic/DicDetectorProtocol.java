package com.holley.wxemcp.ent.model.dic;

public class DicDetectorProtocol {
    private Short id;

    private String name;

    private Short inuse;

    private String remark;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getInuse() {
        return inuse;
    }

    public void setInuse(Short inuse) {
        this.inuse = inuse;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}