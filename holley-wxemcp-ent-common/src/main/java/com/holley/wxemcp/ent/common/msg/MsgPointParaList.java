package com.holley.wxemcp.ent.common.msg;

import java.util.ArrayList;
import java.util.List;

public class MsgPointParaList extends MsgBase {

    int                num   = 0;                            // 配置数量
    List<MsgPointPara> plist = new ArrayList<MsgPointPara>();// 测量点列表

    public void addMsgPointPara(MsgPointPara para) {
        plist.add(para);
        num++;
    }
    public List<MsgPointPara> getList(){
    	return plist;
    }
}
