package com.holley.wxemcp.ent.model.ppf;

import java.math.BigDecimal;

public class DatStaEnergy extends DatStaEnergyKey {
    private BigDecimal energyQ;

    private BigDecimal energyP;

    private BigDecimal pInput;

    private BigDecimal pOutput;

    private BigDecimal qInput;

    private BigDecimal qOutput;

    private Short prop;

    private String remark;

    public BigDecimal getEnergyQ() {
        return energyQ;
    }

    public void setEnergyQ(BigDecimal energyQ) {
        this.energyQ = energyQ;
    }

    public BigDecimal getEnergyP() {
        return energyP;
    }

    public void setEnergyP(BigDecimal energyP) {
        this.energyP = energyP;
    }

    public BigDecimal getpInput() {
        return pInput;
    }

    public void setpInput(BigDecimal pInput) {
        this.pInput = pInput;
    }

    public BigDecimal getpOutput() {
        return pOutput;
    }

    public void setpOutput(BigDecimal pOutput) {
        this.pOutput = pOutput;
    }

    public BigDecimal getqInput() {
        return qInput;
    }

    public void setqInput(BigDecimal qInput) {
        this.qInput = qInput;
    }

    public BigDecimal getqOutput() {
        return qOutput;
    }

    public void setqOutput(BigDecimal qOutput) {
        this.qOutput = qOutput;
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