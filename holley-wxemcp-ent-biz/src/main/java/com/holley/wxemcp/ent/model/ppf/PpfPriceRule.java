package com.holley.wxemcp.ent.model.ppf;

import java.math.BigDecimal;

public class PpfPriceRule {
    private Integer priceid;

    private String name;

    private Short type;

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

    private Short isfund;

    private BigDecimal fund1;

    private BigDecimal fund2;

    private BigDecimal fund3;

    private BigDecimal fund4;

    private BigDecimal fund5;

    private BigDecimal fund6;

    private Short isbase;

    private Short basetype;

    private BigDecimal basevalue;

    private Short ispf;

    private Short standardid;

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

    public Short getIsfund() {
        return isfund;
    }

    public void setIsfund(Short isfund) {
        this.isfund = isfund;
    }

    public BigDecimal getFund1() {
        return fund1;
    }

    public void setFund1(BigDecimal fund1) {
        this.fund1 = fund1;
    }

    public BigDecimal getFund2() {
        return fund2;
    }

    public void setFund2(BigDecimal fund2) {
        this.fund2 = fund2;
    }

    public BigDecimal getFund3() {
        return fund3;
    }

    public void setFund3(BigDecimal fund3) {
        this.fund3 = fund3;
    }

    public BigDecimal getFund4() {
        return fund4;
    }

    public void setFund4(BigDecimal fund4) {
        this.fund4 = fund4;
    }

    public BigDecimal getFund5() {
        return fund5;
    }

    public void setFund5(BigDecimal fund5) {
        this.fund5 = fund5;
    }

    public BigDecimal getFund6() {
        return fund6;
    }

    public void setFund6(BigDecimal fund6) {
        this.fund6 = fund6;
    }

    public Short getIsbase() {
        return isbase;
    }

    public void setIsbase(Short isbase) {
        this.isbase = isbase;
    }

    public Short getBasetype() {
        return basetype;
    }

    public void setBasetype(Short basetype) {
        this.basetype = basetype;
    }

    public BigDecimal getBasevalue() {
        return basevalue;
    }

    public void setBasevalue(BigDecimal basevalue) {
        this.basevalue = basevalue;
    }

    public Short getIspf() {
        return ispf;
    }

    public void setIspf(Short ispf) {
        this.ispf = ispf;
    }

    public Short getStandardid() {
        return standardid;
    }

    public void setStandardid(Short standardid) {
        this.standardid = standardid;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }
}