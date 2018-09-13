package com.holley.wxemcp.ent.model.obj;

import java.math.BigDecimal;
import java.util.Date;

public class ObjEnterprise {

    private Integer    eid;

    private String     disc;

    private String     abbr;

    private String     ecode;

    private String     corporationid;

    private Short      business;

    private Short      grade;

    private String     activities;

    private Short      city;

    private String     registernum;

    private String     registeraddress;

    private String     productionaddress;

    private String     linkman;

    private String     telephone;

    private String     mobile;

    private String     email;

    private String     fax;

    private String     zipcode;

    private String     legalperson;

    private Short      passauthentication;

    private Short      hascertificate;

    private String     gettime;

    private String     annualsales;

    private String     annualtax;

    private BigDecimal annualaddedenergy;

    private BigDecimal annualenergy;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private Short      etype;

    private Integer    ownerid;

    private Short      ownertype;

    private Date       updatetime;
    private String     ownername;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc == null ? null : disc.trim();
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr == null ? null : abbr.trim();
    }

    public String getEcode() {
        return ecode;
    }

    public void setEcode(String ecode) {
        this.ecode = ecode == null ? null : ecode.trim();
    }

    public String getCorporationid() {
        return corporationid;
    }

    public void setCorporationid(String corporationid) {
        this.corporationid = corporationid == null ? null : corporationid.trim();
    }

    public Short getBusiness() {
        return business;
    }

    public void setBusiness(Short business) {
        this.business = business;
    }

    public Short getGrade() {
        return grade;
    }

    public void setGrade(Short grade) {
        this.grade = grade;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities == null ? null : activities.trim();
    }

    public Short getCity() {
        return city;
    }

    public void setCity(Short city) {
        this.city = city;
    }

    public String getRegisternum() {
        return registernum;
    }

    public void setRegisternum(String registernum) {
        this.registernum = registernum == null ? null : registernum.trim();
    }

    public String getRegisteraddress() {
        return registeraddress;
    }

    public void setRegisteraddress(String registeraddress) {
        this.registeraddress = registeraddress == null ? null : registeraddress.trim();
    }

    public String getProductionaddress() {
        return productionaddress;
    }

    public void setProductionaddress(String productionaddress) {
        this.productionaddress = productionaddress == null ? null : productionaddress.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode == null ? null : zipcode.trim();
    }

    public String getLegalperson() {
        return legalperson;
    }

    public void setLegalperson(String legalperson) {
        this.legalperson = legalperson == null ? null : legalperson.trim();
    }

    public Short getPassauthentication() {
        return passauthentication;
    }

    public void setPassauthentication(Short passauthentication) {
        this.passauthentication = passauthentication;
    }

    public Short getHascertificate() {
        return hascertificate;
    }

    public void setHascertificate(Short hascertificate) {
        this.hascertificate = hascertificate;
    }

    public String getGettime() {
        return gettime;
    }

    public void setGettime(String gettime) {
        this.gettime = gettime == null ? null : gettime.trim();
    }

    public String getAnnualsales() {
        return annualsales;
    }

    public void setAnnualsales(String annualsales) {
        this.annualsales = annualsales == null ? null : annualsales.trim();
    }

    public String getAnnualtax() {
        return annualtax;
    }

    public void setAnnualtax(String annualtax) {
        this.annualtax = annualtax == null ? null : annualtax.trim();
    }

    public BigDecimal getAnnualaddedenergy() {
        return annualaddedenergy;
    }

    public void setAnnualaddedenergy(BigDecimal annualaddedenergy) {
        this.annualaddedenergy = annualaddedenergy;
    }

    public BigDecimal getAnnualenergy() {
        return annualenergy;
    }

    public void setAnnualenergy(BigDecimal annualenergy) {
        this.annualenergy = annualenergy;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public Short getEtype() {
        return etype;
    }

    public void setEtype(Short etype) {
        this.etype = etype;
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

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

}
