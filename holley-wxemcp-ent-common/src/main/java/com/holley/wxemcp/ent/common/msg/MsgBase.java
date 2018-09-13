package com.holley.wxemcp.ent.common.msg;

import java.io.Serializable;

public class MsgBase implements Serializable {

    private static final long serialVersionUID = 1L;
    String                    cmdid;                // 命令编码
    int                       cmdtype;              // 命令类型
    String                    commaddr;             // 通讯地址

    public String getCmdid() {
        return cmdid;
    }

    public void setCmdid(String cmdid) {
        this.cmdid = cmdid;
    }

    public int getCmdtype() {
        return cmdtype;
    }

    public void setCmdtype(int cmdtype) {
        this.cmdtype = cmdtype;
    }

    public String getCommaddr() {
        return commaddr;
    }

    public void setCommaddr(String commaddr) {
        this.commaddr = commaddr;
    }

}
