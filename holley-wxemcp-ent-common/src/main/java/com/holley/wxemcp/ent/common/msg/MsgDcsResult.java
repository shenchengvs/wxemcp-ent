package com.holley.wxemcp.ent.common.msg;

import java.io.Serializable;

public class MsgDcsResult extends MsgBase implements Serializable {

    private static final long serialVersionUID = 1L;
    int                       result;               // 1:成功，其他失败
    String                    errorInfo;
    MsgBase                   data;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public MsgBase getData() {
        return data;
    }

    public void setData(MsgBase data) {
        this.data = data;
    }

}
