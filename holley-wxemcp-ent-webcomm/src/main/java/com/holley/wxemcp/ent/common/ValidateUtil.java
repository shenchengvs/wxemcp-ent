package com.holley.wxemcp.ent.common;

import java.util.Calendar;

import com.holley.platform.common.constants.Globals;
import com.holley.platform.common.dataobject.LoginCountBean;
import com.holley.platform.common.util.DateUtil;
import com.holley.wxemcp.ent.common.cache.WxEmcpEntCacheUtil;
import com.holley.wxemcp.ent.common.constants.KeySessionTypeEnum;

public class ValidateUtil {

    /**
     * 登录失败处理，记录短时间的次数和登录时间，若超过5次，必须延时等待
     * 
     * @param account
     * @return
     */
    public static LoginCountBean initLogin(String account, KeySessionTypeEnum type) {
        Calendar now = Calendar.getInstance();

        int failCount = 1;
        String errmsg = null;
        boolean refuseLogin = false;

        int loginInterval = Globals.LOGIN_INTERVAL; // 短时登录失败超多次后再次允许登录的时间间隔
        int totalFailCount = Globals.LOGIN_FAIL_TOTAL; // 总共登录失败次数
        // Object obj = Globals.LOGIN_COUNT_MAP.get(account);
        LoginCountBean lcbean = WxEmcpEntCacheUtil.getLoginCount(account, type);
        if (lcbean != null) {
            long mins = DateUtil.calcMinuteBetween2Dates(lcbean.getLogintime(), now.getTime());
            if (Math.abs(mins) > loginInterval) {// 记录三十分钟内频繁登录失败的次数
                failCount = 1;// 等待时间超过30分钟，允许重新登录，重新计数
                refuseLogin = false;
            } else {
                failCount = lcbean.getCount() + 1;
                if (failCount > totalFailCount) { // 若超过5次，必须延时等待
                    long remain = loginInterval - mins;
                    errmsg = "该用户登录失败超过" + totalFailCount + "次，请";
                    if (remain > 0) {
                        errmsg += remain + "分钟后";
                    } else {
                        long start = lcbean.getLogintime().getTime();
                        long end = Calendar.getInstance().getTime().getTime();
                        remain = 60 - ((end - start) % (1000 * 60) / 1000);
                        errmsg += remain + "秒后";
                    }
                    errmsg += "重试!";
                    refuseLogin = true;
                }
            }
        } else {
            lcbean = new LoginCountBean();
            lcbean.setAccount(account);
        }
        lcbean.setCount(failCount);
        lcbean.setReTryCount(totalFailCount - failCount);
        lcbean.setLoginFailMsg(errmsg);
        lcbean.setRefuseLogin(refuseLogin);
        if (failCount <= totalFailCount) {
            lcbean.setLogintime(now.getTime());
        }
        WxEmcpEntCacheUtil.setLoginCount(account, type, lcbean);
        return lcbean;
    }

    /**
     * 登录成功后清除登录异常验证bean
     * 
     * @param account
     */
    public static void clearLoginBean(String account, KeySessionTypeEnum type) {
        WxEmcpEntCacheUtil.removeLoginCount(account, type);
    }

}
