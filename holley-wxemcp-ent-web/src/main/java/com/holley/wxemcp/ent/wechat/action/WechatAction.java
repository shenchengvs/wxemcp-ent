package com.holley.wxemcp.ent.wechat.action;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.holley.wxemcp.ent.action.BaseAction;
import com.holley.wxemcp.ent.common.util.WxEmcpEntUtil;
import com.holley.wxemcp.ent.model.def.WxAuthorizeRs;
import com.holley.wxemcp.ent.model.def.WxemcpEntResultBean;

public class WechatAction extends BaseAction {

    private static final long   serialVersionUID = 1L;
    private final static Logger logger           = Logger.getLogger(WechatAction.class);

    /**
     * 微信授权调用
     * 
     * @return
     */
    public String authorize() {
        // return value
        WxAuthorizeRs rs = new WxAuthorizeRs();
        // 获取code
        String code = getParameter("code");
        JSONObject json = WxEmcpEntUtil.getOpenId(code);
        logger.info(json);
        if (!json.has("errmsg")) {
            String openid = json.getString("openid");
            rs.setOpenid(openid);
        } else {
            logger.error("微信openid获取失败: " + json.getString("errmsg"));
            wxemcpEntResultBean.setRet(Integer.parseInt(json.getString("errcode")));
            wxemcpEntResultBean.setMsg(json.getString("errmsg"));
        }
        wxemcpEntResultBean.setData(rs);
        return SUCCESS;
    }

    public WxemcpEntResultBean getWxemcpEntResultBean() {
        return wxemcpEntResultBean;
    }
}
