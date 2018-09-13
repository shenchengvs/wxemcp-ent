package com.holley.wxemcp.ent.web.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.holley.platform.model.def.WebUser;
import com.opensymphony.xwork2.ActionInvocation;

/**
 * 页面拦截器<br>
 * 
 * @author sc
 */
public class PermissionInterceptor extends BaseInterceptor {

    private static final Logger logger = Logger.getLogger(PermissionInterceptor.class);

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        String result = null;
        // String accountKey = getStringData("accountKey");
        // String result = null;
        // if (StringUtil.isEmpty(accountKey)) {
        // return "relogin";
        // }
        // WxemcpEntWebUser user = getUser(accountKey);
        //
        // if (user == null) {
        // return "relogin";
        // }
        // WxEmcpEntLocalUtil.setUserLocal(user);
        try {
            result = invocation.invoke();
        } catch (Exception e) {
            setStringData("msg", "系统异常");
            result = "msg";
        }
        return result;
    }

    /**
     * 检测是否登录
     * 
     * @return
     */
    private WebUser checkIsLogin() {
        return null;
    }

    /**
     * 检测是否更换了登录点
     * 
     * @param webUser
     * @return
     */
    private boolean checkSessionid(WebUser user) {
        // 判断用户是否换了地点登录
        logger.info("PermissionInterceptor-----------" + user.getSessionid() + "==" + getSessionId());
        if (!StringUtils.equals(user.getSessionid(), getSessionId())) {
            logger.info("检测到用户【" + user.getAccount() + "】更换浏览器二次登陆-----------" + user.getSessionid() + "==" + getSessionId());
            return false;
        }
        return true;
    }

}
