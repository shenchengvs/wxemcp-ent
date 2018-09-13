package com.holley.wxemcp.ent.common.action;

import com.holley.wxemcp.ent.action.BaseAction;
import com.holley.wxemcp.ent.model.def.WxemcpEntResultBean;

/**
 * 公共
 * 
 * @author sc
 */
public class CommonAction extends BaseAction {
	
	private static final long serialVersionUID = 1L;
	
    /**
     * 产品介绍
     * 
     * @return
     */
    public String initProductPage() {
        return SUCCESS;
    }

    /**
     * 帮助中心
     * 
     * @return
     */
    public String initHelpPage() {
        return SUCCESS;
    }
    
    public WxemcpEntResultBean getWxemcpEntResultBean() {
        return wxemcpEntResultBean;
    }
}
