package com.holley.wxemcp.ent.model.def;

import com.holley.platform.common.util.StringUtil;
import com.holley.wxemcp.ent.common.constants.RetTypeEnum;

/**
 * 通用数据调用结果返回bean
 * 
 * @author sc
 */
public class WxemcpEntResultBean {

    private int    ret = 0; // 返回参数编码
    private String msg;    // 返回信息
    private Object data;   // 数据

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMsg() {
        if (StringUtil.isNotEmpty(msg)) {
            return msg;
        }
        return RetTypeEnum.getText(ret);
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
