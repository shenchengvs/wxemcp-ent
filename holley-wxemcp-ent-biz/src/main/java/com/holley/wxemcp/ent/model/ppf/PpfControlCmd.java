package com.holley.wxemcp.ent.model.ppf;

import java.util.Date;

public class PpfControlCmd extends PpfControlCmdKey {
    private Short cmdtype;

    private String params;

    private Short operatetype;

    private Date operatetime;

    private Short result;

    public Short getCmdtype() {
        return cmdtype;
    }

    public void setCmdtype(Short cmdtype) {
        this.cmdtype = cmdtype;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    public Short getOperatetype() {
        return operatetype;
    }

    public void setOperatetype(Short operatetype) {
        this.operatetype = operatetype;
    }

    public Date getOperatetime() {
        return operatetime;
    }

    public void setOperatetime(Date operatetime) {
        this.operatetime = operatetime;
    }

    public Short getResult() {
        return result;
    }

    public void setResult(Short result) {
        this.result = result;
    }
}