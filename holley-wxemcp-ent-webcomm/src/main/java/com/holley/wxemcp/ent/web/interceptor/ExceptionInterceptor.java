package com.holley.wxemcp.ent.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by Variant on 15/12/17.
 */
public class ExceptionInterceptor extends AbstractInterceptor {

    private static final long serialVersionUID = 263973631301649276L;

    public ExceptionInterceptor() {

    }

    @Override
    public String intercept(ActionInvocation invocation) {
        String result = null;
        try {
            result = invocation.invoke();
            return result;
        } catch (Exception e) {
            System.out.println("==============异常开始=============");
            e.printStackTrace();
            System.out.println("==============异常结束=============");
        } finally {
            return result;
        }
    }

}
