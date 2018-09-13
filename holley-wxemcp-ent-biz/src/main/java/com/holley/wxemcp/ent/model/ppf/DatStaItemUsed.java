package com.holley.wxemcp.ent.model.ppf;

import java.math.BigDecimal;

public class DatStaItemUsed extends DatStaItemUsedKey {
    private BigDecimal used;

    private BigDecimal energy;

    private Short prop;

    private String remark;

    public BigDecimal getUsed() {
        return used;
    }

    public void setUsed(BigDecimal used) {
        this.used = used;
    }

    public BigDecimal getEnergy() {
        return energy;
    }

    public void setEnergy(BigDecimal energy) {
        this.energy = energy;
    }

    public Short getProp() {
        return prop;
    }

    public void setProp(Short prop) {
        this.prop = prop;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}