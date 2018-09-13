package com.holley.wxemcp.ent.sys.action;

import java.util.Date;

import javax.annotation.Resource;

import com.holley.platform.common.util.StringUtil;
import com.holley.wxemcp.ent.action.BaseAction;
import com.holley.wxemcp.ent.common.constants.LoginStatusTypeEnum;
import com.holley.wxemcp.ent.common.constants.RetTypeEnum;
import com.holley.wxemcp.ent.common.constants.WxPushIsShowTypeEnum;
import com.holley.wxemcp.ent.common.constants.WxPushStatusTypeEnum;
import com.holley.wxemcp.ent.common.util.WxEmcpEntLocalUtil;
import com.holley.wxemcp.ent.model.def.AccountInfoBase;
import com.holley.wxemcp.ent.model.def.WxemcpEntResultBean;
import com.holley.wxemcp.ent.model.def.WxemcpEntWebUser;
import com.holley.wxemcp.ent.model.obj.ObjEnterprise;
import com.holley.wxemcp.ent.model.ppf.PpfEnterpriseWechat;
import com.holley.wxemcp.ent.service.emcp.AccountService;

/**
 * 用户相关ACTION
 * 
 * @author sc
 */
public class AccountAction extends BaseAction {

    @Resource
    private AccountService accountService;

    /**
     * 个人中心页面
     * 
     * @return
     */
    public String initAccountPage() {
        return SUCCESS;
    }

    /**
     * 查询个人中心
     * 
     * @return
     */
    public String queryAccount() {
        WxemcpEntWebUser wxemcpEntWebUser = getUser();
        String openId = getParameter("openId");
        ObjEnterprise objEnterprise = accountService.selectEnterpriseByPrimaryKey(wxemcpEntWebUser.getEntId());
        AccountInfoBase accountInfoBase = new AccountInfoBase();
        accountInfoBase.setAccount(wxemcpEntWebUser.getAccount());
        accountInfoBase.setEntName(objEnterprise.getDisc());
        accountInfoBase.setPhone(objEnterprise.getTelephone());

        if (WxEmcpEntLocalUtil.eids.contains(wxemcpEntWebUser.getEntId())) {
            if (StringUtil.isEmpty(openId)) {
                accountInfoBase.setIsShow(WxPushIsShowTypeEnum.UN_SHOW.getValue());
            } else {
                PpfEnterpriseWechat enterpriseWechat = accountService.selectEnterpriseWechatByPrimaryKey(openId);
                if (enterpriseWechat == null) {
                    accountInfoBase.setIsShow(WxPushIsShowTypeEnum.UN_SHOW.getValue());
                } else {
                    accountInfoBase.setIsShow(WxPushIsShowTypeEnum.SHOW.getValue());
                    if (WxPushStatusTypeEnum.PUSH.getShortValue().equals(enterpriseWechat.getPushStatus())) {
                        accountInfoBase.setIsPush(WxPushStatusTypeEnum.PUSH.getValue());
                    } else {
                        accountInfoBase.setIsPush(WxPushStatusTypeEnum.UN_PUSH.getValue());
                    }
                }
            }
        } else {
            accountInfoBase.setIsShow(WxPushIsShowTypeEnum.UN_SHOW.getValue());
        }
        wxemcpEntResultBean.setData(accountInfoBase);
        return SUCCESS;
    }

    public String logout() {
        String openId = getParameter("openId");
        if (StringUtil.isEmpty(openId)) {
            this.wxemcpEntResultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        PpfEnterpriseWechat enterpriseWechat = new PpfEnterpriseWechat();
        enterpriseWechat.setOpenId(openId);
        enterpriseWechat.setUpdateTime(new Date());
        enterpriseWechat.setLoginStatus(LoginStatusTypeEnum.UN_LOGIN.getShortValue());
        accountService.updateEnterpriseWechatByPrimaryKeySelective(enterpriseWechat);
        return SUCCESS;
    }

    public String changePushStatus() {
        String openId = getParameter("openId");
        int pushStatus = getParamInt("pushStatus");
        WxPushStatusTypeEnum wxPushStatusType = WxPushStatusTypeEnum.getEnmuByValue(pushStatus);
        if (StringUtil.isEmpty(openId) || wxPushStatusType == null) {
            this.wxemcpEntResultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        PpfEnterpriseWechat enterpriseWechat = new PpfEnterpriseWechat();
        enterpriseWechat.setOpenId(openId);
        enterpriseWechat.setUpdateTime(new Date());
        enterpriseWechat.setPushStatus(wxPushStatusType.getShortValue());
        accountService.updateEnterpriseWechatByPrimaryKeySelective(enterpriseWechat);
        return SUCCESS;
    }

    public WxemcpEntResultBean getWxemcpEntResultBean() {
        return wxemcpEntResultBean;
    }
}
