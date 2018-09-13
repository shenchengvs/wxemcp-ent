package com.holley.wxemcp.ent.frame.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.holley.emcp.sms.vo.PpfSmsSendValidate;
import com.holley.platform.common.security.RijndaelUtil;
import com.holley.platform.common.util.DateUtil;
import com.holley.platform.common.util.StringUtil;
import com.holley.platform.common.web.util.Validator;
import com.holley.platform.model.sys.SysAccount;
import com.holley.wxemcp.ent.action.BaseAction;
import com.holley.wxemcp.ent.common.SmsSendUtil;
import com.holley.wxemcp.ent.common.cache.WxEmcpEntCacheUtil;
import com.holley.wxemcp.ent.common.constants.EnterpriseTypeEnum;
import com.holley.wxemcp.ent.common.constants.OriginTypeEnum;
import com.holley.wxemcp.ent.common.constants.RetTypeEnum;
import com.holley.wxemcp.ent.common.constants.SendMsgTypeEnum;
import com.holley.wxemcp.ent.common.constants.SmsSendStatusEnum;
import com.holley.wxemcp.ent.common.constants.SmsTypeEnum;
import com.holley.wxemcp.ent.common.constants.WxemcpEntGlobals;
import com.holley.wxemcp.ent.common.util.WxEmcpEntLocalUtil;
import com.holley.wxemcp.ent.model.def.WxemcpEntResultBean;
import com.holley.wxemcp.ent.model.def.WxemcpEntWebUser;
import com.holley.wxemcp.ent.model.obj.ObjEnterprise;
import com.holley.wxemcp.ent.model.sys.SysUnregisterAccount;
import com.holley.wxemcp.ent.service.emcp.AccountService;

/**
 * @author sc
 */
public class LoginAction extends BaseAction {

    private static final long   serialVersionUID = 1L;
    private final static Logger logger           = Logger.getLogger(LoginAction.class);
    @Resource
    private AccountService      accountService;

    /**
     * 体验登录页面
     * 
     * @return
     */
    public String initExperiencePage() {
        return SUCCESS;
    }

    /**
     * 体验用户登录
     * 
     * @return
     */
    public String experience() {
        String code = getParameter("code");
        String phone = getParameter("phone");
        int entType = getParamInt("entType");// EnterpriseTypeEnum
        if (EnterpriseTypeEnum.PARK.getValue() != entType && EnterpriseTypeEnum.PREPAY.getValue() != entType) {
            entType = EnterpriseTypeEnum.PARK.getValue();
        }
        if (StringUtil.isNull(code, phone) || code.length() != 4 || !Validator.isMobile(phone)) {
            wxemcpEntResultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        if (!code.equals(WxEmcpEntCacheUtil.getPhoneCode(phone))) {
            wxemcpEntResultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            wxemcpEntResultBean.setMsg("验证码有误");
            return SUCCESS;
        }
        SysUnregisterAccount unAccount = accountService.selectUnregisterAccountByPrimaryKey(phone);
        if (unAccount == null) {
            wxemcpEntResultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            wxemcpEntResultBean.setMsg("用户信息有误，请重新验证");
            return SUCCESS;
        }
        SysUnregisterAccount unregisterAccount = new SysUnregisterAccount();
        unregisterAccount.setUpdatetime(new Date());
        unregisterAccount.setPhone(phone);
        unregisterAccount.setLogincount(unAccount.getLogincount() + 1);
        accountService.updateUnregisterAccountByPrimaryKeySelective(unregisterAccount);

        ObjEnterprise objEnterprise = accountService.selectEnterpriseByPrimaryKey(WxemcpEntGlobals.DEFAULT_UNREGISTER_ENT);
        if (objEnterprise == null) {
            wxemcpEntResultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            wxemcpEntResultBean.setMsg("默认绑定的企业不存在");
            return SUCCESS;
        }
        WxemcpEntWebUser wxemcpEntWebUser = WxEmcpEntLocalUtil.addUnregisterUser(phone, objEnterprise, (short) entType);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("accountKey", encrypt(wxemcpEntWebUser.getAccount()));
        map.put("entType", entType);
        map.put("entName", objEnterprise.getDisc());
        wxemcpEntResultBean.setData(map);
        WxEmcpEntCacheUtil.removePhoneCode(phone);
        return SUCCESS;
    }

    /**
     * 登录页面初始化
     * 
     * @return
     */
    public String initLoginPage() {
        return SUCCESS;
    }

    /**
     * 发送短信
     * 
     * @return
     */
    public String sendPhoneCode() {
        String phone = getParameter("phone");
        if (!Validator.isMobile(phone)) {
            wxemcpEntResultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        Date now = new Date();
        SysUnregisterAccount unAccount = accountService.selectUnregisterAccountByPrimaryKey(phone);
        SysUnregisterAccount unregisterAccount = new SysUnregisterAccount();
        unregisterAccount.setUpdatetime(now);
        unregisterAccount.setPhone(phone);
        if (unAccount != null) {
            if (DateUtil.DateToStr(now, DateUtil.TIME_SHORT).equals(DateUtil.DateToStr(unAccount.getUpdatetime(), DateUtil.TIME_SHORT))) {
                if (unAccount.getCodecount() >= 5) {
                    wxemcpEntResultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
                    wxemcpEntResultBean.setMsg("验证输入次数超限，请明天再试");
                    return SUCCESS;
                } else {
                    unregisterAccount.setCodecount(unAccount.getCodecount() + 1);
                }
            } else {
                unregisterAccount.setCodecount(1);
            }
            accountService.updateUnregisterAccountByPrimaryKeySelective(unregisterAccount);
        } else {
            unregisterAccount.setCodecount(1);
            unregisterAccount.setLogincount(0);
            unregisterAccount.setOrigin(OriginTypeEnum.MOBILE.getShortValue());
            accountService.insertUnregisterAccountSelective(unregisterAccount);
        }

        String code = StringUtil.randomNumber(4);
        PpfSmsSendValidate validate = new PpfSmsSendValidate();
        validate.setCustomerid(-1);
        validate.setPhone(phone);
        validate.setType(SmsTypeEnum.VERIFICATIONCODE.getShortValue());
        validate.setContent("验证码" + code + "，您正在华立能管家企业平台进行验证，验证码10分钟内有效。");
        validate.setSendtype(SendMsgTypeEnum.MANUAL.getShortValue());
        validate.setStatus(SmsSendStatusEnum.SENDING.getShortValue());
        validate.setAddtime(new Date());
        validate.setCode(code);
        validate.setProduct("华立能管家企业平台");
        validate.setMinute("10");
        // 验证码存储
        WxEmcpEntCacheUtil.setPhoneCode(phone, code);
        // AlidayuSendPhone.sendPhoneCode(phone, code);
        // 短信发送
        // SmsSendUtil.sendMsg(validate);
        SmsSendUtil.sendMsgCloud(validate);
        System.out.println("code:" + code);
        return SUCCESS;
    }

    /**
     * 用户登录系统
     * 
     * @return
     * @throws Exception
     */
    public String login() throws Exception {
        // 判断当前浏览器是否处于登录状态，如果已登录，则直接跳转到主页，否则跳转到登录页面(待修改)

        String account = getParameter("account");
        String password = getParameter("password");
        // String verifycode = this.getParameter("verifycode");

        // 校验登录参数
        if (!validateParams(account, password, null)) {
            return SUCCESS;
        }

        SysAccount sysAccount = accountService.selectAccountByPrimaryKey(account);

        if (sysAccount == null) {
            wxemcpEntResultBean.setRet(RetTypeEnum.PASSWORD_ERROR.getValue());
            return SUCCESS;
        }

        if (!RijndaelUtil.encodePassword(password).equals(sysAccount.getPassword())) {
            wxemcpEntResultBean.setRet(RetTypeEnum.PASSWORD_ERROR.getValue());
            return SUCCESS;
        }

        if (sysAccount.getDepartmentid() != null && sysAccount.getDepartmentid() > 0) {
            ObjEnterprise objEnterprise = accountService.selectEnterpriseByPrimaryKey(sysAccount.getDepartmentid());
            if (objEnterprise == null) {
                wxemcpEntResultBean.setRet(RetTypeEnum.USER_ERROR.getValue());
                wxemcpEntResultBean.setMsg("未知企业");
                return SUCCESS;
            }
            WxemcpEntWebUser wxemcpEntWebUser = WxEmcpEntLocalUtil.addUser(sysAccount, objEnterprise);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("accountKey", encrypt(wxemcpEntWebUser.getAccount()));
            map.put("entType", wxemcpEntWebUser.getEntType());
            map.put("entName", objEnterprise.getDisc());
            wxemcpEntResultBean.setData(map);
            return SUCCESS;
        } else {
            wxemcpEntResultBean.setRet(RetTypeEnum.USER_ERROR.getValue());
            return SUCCESS;
        }

        // 校验验证码
        // String imagecode = WxEmcpEntCacheUtil.getImgValidateCode(getSessionId());
        // if (!verifycode.equalsIgnoreCase(imagecode)) {
        // this.success = false;
        // this.message = "验证码不正确!";
        // return SUCCESS;
        // }

        // // 校验账户
        // SysAccount sysAccount = accountRoleService.selectAccountByPK(loginuser);
        // if (sysAccount == null) {
        // this.success = false;
        // this.message = "账号不存在";
        // return SUCCESS;
        // }

        // LoginCountBean lcbean = ValidateUtil.initLogin(loginuser, KeySessionTypeEnum.WXEMCP_ENT_WEB);
        // if (lcbean.isRefuseLogin()) {
        // return loginError(lcbean.getLoginFailMsg());
        // }
        //
        // // 清除登录失败次数
        // ValidateUtil.clearLoginBean("", KeySessionTypeEnum.WXEMCP_ENT_WEB);

    }

    /**
     * 用户退出系统
     * 
     * @return
     */
    // public String logout() {
    // WebUser user = this.getSessionWebUser();
    // if (user != null) {
    // HostLogUtils.recordLoginlog(user.getAccount(), getRemoteIP(), "退出系统");
    // if (StringUtils.equals(user.getSessionid(), getSessionId())) {
    // WxEmcpEntCacheUtil.removieSession(user.getAccount(), KeySessionTypeEnum.WXEMCP_ENT_WEB);
    // }
    // }
    // return SUCCESS;
    // }

    private boolean validateParams(String account, String password, String verifycode) {

        if (StringUtil.isEmpty(account)) {
            wxemcpEntResultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            wxemcpEntResultBean.setMsg("请正确填写用户名!");

            // owxemcpEntResultBean.setData(data);
            return false;
        }
        if (StringUtil.isEmpty(password) || !Validator.isPassword(password)) {
            wxemcpEntResultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            wxemcpEntResultBean.setMsg("请正确填写[6-16]位数字字母组合的密码!");
            return false;
        }

        /*
         * if (StringUtil.isEmpty(verifycode)) { this.success = false; this.message = "请输入验证码!"; return false; }
         */
        return true;
    }

    private String loginError(String errmsg) {
        this.success = false;
        this.message = errmsg;
        return SUCCESS;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public WxemcpEntResultBean getWxemcpEntResultBean() {
        return wxemcpEntResultBean;
    }

}
