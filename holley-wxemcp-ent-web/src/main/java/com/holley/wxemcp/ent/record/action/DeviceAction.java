package com.holley.wxemcp.ent.record.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.holley.platform.common.constants.Globals;
import com.holley.platform.common.dataobject.Page;
import com.holley.wxemcp.ent.action.BaseAction;
import com.holley.wxemcp.ent.model.def.RtuStatusInfoBase;
import com.holley.wxemcp.ent.model.def.RtuStatusInfoVo;
import com.holley.wxemcp.ent.model.def.WxemcpEntResultBean;
import com.holley.wxemcp.ent.model.def.WxemcpEntWebUser;
import com.holley.wxemcp.ent.service.emcp.RecordService;

public class DeviceAction extends BaseAction {

    @Resource
    private RecordService recordService;

    public String initRtuStatusPage() {
        return SUCCESS;
    }

    /**
     * 查询终端状态信息
     * 
     * @return
     */
    public String queryRtuStatusInfos() {
        WxemcpEntWebUser wxemcpEntWebUser = getUser();
        int pageIndex = getParamInt("pageIndex");
        int rtuStatus = getParamInt("rtuStatus");
        Page page = returnPage(pageIndex, limit);
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("eid", wxemcpEntWebUser.getEntId());
        param.put(Globals.PAGE, page);
        if (rtuStatus >= 0) {
            param.put("rtuStatus", rtuStatus);
        }
        List<RtuStatusInfoVo> list = recordService.selectRtuStatusInfosByPage(param);
        RtuStatusInfoBase rtuStatusInfoBase = new RtuStatusInfoBase(page.getTotalProperty(), pageIndex, limit);
        rtuStatusInfoBase.setDatas(list);
        wxemcpEntResultBean.setData(rtuStatusInfoBase);
        return SUCCESS;
    }
    
    public WxemcpEntResultBean getWxemcpEntResultBean() {
        return wxemcpEntResultBean;
    }
}
