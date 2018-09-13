package com.holley.emcp.model.com;

import com.holley.emcp.model.ppf.PpfSmsSend;

public class PpfSmsSendValidate extends PpfSmsSend {

    private static final long serialVersionUID = 1L;
    private String            code;
    private String            product;
    private String            minute;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }
}
