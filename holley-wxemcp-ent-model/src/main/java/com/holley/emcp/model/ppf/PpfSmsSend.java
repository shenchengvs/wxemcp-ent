package com.holley.emcp.model.ppf;

import java.io.Serializable;
import java.util.Date;

public class PpfSmsSend implements Serializable {

    private static final long serialVersionUID = 7740186628715143301L;

    private Integer           smsid;

    private Integer           customerid;

    private String            phone;

    private Short             type;

    private Date              sendtime;

    private String            content;

    private Short             status;

    private Short             sendtype;

    private String            account;

    private Date              addtime;

    public Integer getSmsid() {
        return smsid;
    }

    public void setSmsid(Integer smsid) {
        this.smsid = smsid;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getSendtype() {
        return sendtype;
    }

    public void setSendtype(Short sendtype) {
        this.sendtype = sendtype;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

}
