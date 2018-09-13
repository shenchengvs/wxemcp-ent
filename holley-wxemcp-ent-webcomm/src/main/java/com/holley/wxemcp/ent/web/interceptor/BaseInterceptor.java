package com.holley.wxemcp.ent.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.holley.platform.common.security.SecurityUtil;
import com.holley.wxemcp.ent.common.constants.WxemcpEntGlobals;
import com.holley.wxemcp.ent.common.util.WxEmcpEntLocalUtil;
import com.holley.wxemcp.ent.model.def.WxemcpEntWebUser;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public abstract class BaseInterceptor extends AbstractInterceptor {

    private static final long   serialVersionUID = 299528989481069713L;
    @SuppressWarnings("unused")
    private static final Logger logger           = Logger.getLogger(BaseInterceptor.class);

    @Override
    public abstract String intercept(ActionInvocation invocation) throws Exception;

    protected String getNamespce() {
        return ServletActionContext.getActionMapping().getNamespace();
    }

    protected HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();
    }

    protected HttpServletResponse getResponse() {
        return ServletActionContext.getResponse();
    }

    protected String getServletPath() {
        HttpServletRequest request = ServletActionContext.getRequest();
        return request.getServletPath();
    }

    protected WxemcpEntWebUser getUser(String accountKey) {

        try {// yjapt:iAbd/G9KFwM=
             // hltest:H5AFWOU1HUM=
             // hladmin：RGRGT8PFmck=
             // chizheng:CqMnvawrYsO4Jm4xghLQCg==
            String account = SecurityUtil.decrypt(accountKey, WxemcpEntGlobals.ENCODE_KEY);
            return WxEmcpEntLocalUtil.returnUser(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected String getSessionId() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String jsessionID = request.getSession().getId();
        if (jsessionID.length() > 32) {
            jsessionID = jsessionID.substring(0, 32);
        }
        return jsessionID;
    }

    protected String getStringData(String key) {
        HttpServletRequest request = getRequest();
        String data = request.getParameter(key);
        return data != null ? data : "";
    }

    protected void setStringData(String key, String value) {
        HttpServletRequest request = getRequest();
        request.setAttribute(key, value);
    }
}
