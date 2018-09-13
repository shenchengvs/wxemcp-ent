package com.holley.wxemcp.ent.model.ppf;

import java.math.BigDecimal;

public class PpfPriceRuleOther {
    private Integer priceid;

    private String name;

    private Short type;

    private Short energytype;

    private BigDecimal value1;

    private BigDecimal value2;

    private BigDecimal value3;

    private BigDecimal value4;

    private BigDecimal value5;

    private Long energy1;

    private Long energy2;

    private Long energy3;

    private Long energy4;

    private Long energy5;

    private Integer eid;

    public Integer getPriceid() {
        return priceid;
    }

    public void setPriceid(Integer priceid) {
        this.priceid = priceid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Short getEnergytype() {
        return energytype;
    }

    public void setEnergytype(Short energytype) {
        this.energytype = energytype;
    }

    public BigDecimal getValue1() {
        return value1;
    }

    public void setValue1(BigDecimal value1) {
        this.value1 = value1;
    }

    public BigDecimal getValue2() {
        return value2;
    }

    public void setValue2(BigDecimal value2) {
        this.value2 = value2;
    }

    public BigDecimal getValue3() {
        return value3;
    }

    public void setValue3(BigDecimal value3) {
        this.value3 = value3;
    }

    public BigDecimal getValue4() {
        return value4;
    }

    public void setValue4(BigDecimal value4) {
        this.value4 = value4;
    }

    public BigDecimal getValue5() {
        return value5;
    }

    public void setValue5(BigDecimal value5) {
        this.value5 = value5;
    }

    public Long getEnergy1() {
        return energy1;
    }

    public void setEnergy1(Long energy1) {
        this.energy1 = energy1;
    }

    public Long getEnergy2() {
        return energy2;
    }

    public void setEnergy2(Long energy2) {
        this.energy2 = energy2;
    }

    public Long getEnergy3() {
        return energy3;
    }

    public void setEnergy3(Long energy3) {
        this.energy3 = energy3;
    }

    public Long getEnergy4() {
        return energy4;
    }

    public void setEnergy4(Long energy4) {
        this.energy4 = energy4;
    }

    public Long getEnergy5() {
        return energy5;
    }

    public void setEnergy5(Long energy5) {
        this.energy5 = energy5;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }
}