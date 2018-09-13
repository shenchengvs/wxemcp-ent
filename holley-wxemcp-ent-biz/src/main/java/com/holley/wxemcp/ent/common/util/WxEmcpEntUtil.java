package com.holley.wxemcp.ent.common.util;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.holley.emcp.model.ppf.TemplateData;
import com.holley.platform.common.util.DateUtil;
import com.holley.platform.common.util.StringUtil;
import com.holley.wxemcp.ent.common.cache.CacheCloudUtil;
import com.holley.wxemcp.ent.common.constants.WxemcpEntGlobals;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class WxEmcpEntUtil {

    static Logger         LOG              = LoggerFactory.getLogger(WxEmcpEntUtil.class);
    private static String KEY_ACCESS_TOKEN = "KEY_ACCESS_TOKEN_MP_ENT";

    public static Map<String, Date> getDateTimeByType(int datetype, String date) {

        if (datetype == 1) {
            Map<String, Date> mp = new HashMap<String, Date>();
            Date now = DateUtil.StrToDate(date, DateUtil.TIME_SHORT);
            Date tobeg = returnFirstDatetime(now, 0);// 当天起始时间
            Date labeg = returnFirstDatetime(now, -1);// 前一天起始时间
            Date toend = returnLastDatetime(now, 0);// 当天结束时间

            Date latobeg = returnFirstDatetime(now, -7);
            Date latoend = returnLastDatetime(now, -7);

            mp.put("tobeg", tobeg);
            mp.put("labeg", labeg);

            mp.put("latobeg", latobeg);
            mp.put("latoend", latoend);
            mp.put("toend", toend);
            return mp;
        } else {
            Map<String, Date> mp = new HashMap<String, Date>();
            Date now = DateUtil.StrToDate(date, DateUtil.MONTHTIME);
            Date firstDayOfMonth = returnFirstDatetime(DateUtil.getFirstDayOfMonth(now), 0);
            Date lastDayOfMonth = returnLastDatetime(DateUtil.getLastDayOfMonth(now), 0);

            Calendar ca = Calendar.getInstance();// 得到一个Calendar的实例
            ca.setTime(now); // 设置时间为当前时间
            ca.add(Calendar.YEAR, -1); // 年份减1
            Date lastMonth = ca.getTime();

            Date firstDayOfMonth2 = returnFirstDatetime(DateUtil.getFirstDayOfMonth(lastMonth), 0);
            Date lastDayOfMonth2 = returnLastDatetime(DateUtil.getLastDayOfMonth(lastMonth), 0);

            Calendar ca2 = Calendar.getInstance();// 得到一个Calendar的实例
            ca2.setTime(now); // 设置时间为当前时间
            ca2.add(Calendar.MONTH, -1); // 月份减1
            Date lastMonth2 = ca2.getTime();

            Date firstDayOfMonth3 = returnFirstDatetime(DateUtil.getFirstDayOfMonth(lastMonth2), 0);
            Date lastDayOfMonth3 = returnLastDatetime(DateUtil.getLastDayOfMonth(lastMonth2), 0);
            mp.put("toend", lastDayOfMonth);
            mp.put("tobeg", firstDayOfMonth);
            mp.put("labeg", firstDayOfMonth3);
            mp.put("latobeg", firstDayOfMonth2);
            mp.put("latoend", lastDayOfMonth2);
            return mp;

        }

    }

    public static Date returnFirstDatetime(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date returnLastDatetime(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * 发送微信模板消息
     * 
     * @param openid 微信openid
     * @param time 统计时间
     * @param customerid 用户id
     * @param useNew 采用新档案
     */
    public static void sendTemplateMsg(String openid, String first, String time, String content) {
        if (StringUtil.isNotEmpty(openid)) {
            // 发送模板消息
            final String template_url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";
            TemplateData templ = TemplateData.New();
            templ.setTouser(openid);
            templ.setTemplate_id(WxemcpEntGlobals.WX_WARN_TEMPLATE_ID);
            if (WxemcpEntGlobals.RELEASE_MODE == 1) {
                // 开发模式
                templ.add("first", first, "#173177");
                templ.add("time", time, "#173177");
                templ.add("yuebuzu", content, "#000");
            } else {
                // 发布模式
                templ.add("first", first, "#173177");
                templ.add("occurtime", time, "#173177");
                templ.add("content", content, "#000");
            }
            String json = templ.build();
            // String result = HttpClientUtil.postJson(template_url + accessToken(), json);
            HttpClientHelper clientHelper = HttpClientHelper.getInstance();
            String result = clientHelper.doPostJson(template_url + accessToken(), json);
            JSONObject jo = JSONObject.fromObject(result);
            LOG.info("sendTemplateMsg:" + result);
            if (result.equals("error") || jo.getInt("errcode") != 0) {
                LOG.error("发送微信模板消息失败：" + jo.getString("errmsg"));
            }
        }
    }

    /**
     * 微信全局调用accessToken
     * 
     * @return
     */
    public static String accessToken() {
        String token = CacheCloudUtil.getString(KEY_ACCESS_TOKEN);
        if (token == null) {
            String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + WxemcpEntGlobals.WX_APP_ID + "&secret=" + WxemcpEntGlobals.WX_APP_SECRET;
            HttpClientHelper clientHelper = HttpClientHelper.getInstance();
            String result = clientHelper.doGet(url);
            LOG.info("accessToken:" + result);
            // String result = httpClientUtil.doGet(url, "UTF-8");
            JSONObject json = JSONObject.fromObject(result);
            if (!json.has("errmsg")) {
                token = json.getString("access_token");
                CacheCloudUtil.setString(KEY_ACCESS_TOKEN, token, 600);
            } else {
                LOG.info("accessToken-->errorMsg:" + json.getString("errmsg"));
            }
        }
        return token;
    }

    public static JSONObject getOpenId(String code) {
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token";
        Map<String, String> param = new HashMap<String, String>(4);
        param.put("appid", WxemcpEntGlobals.WX_APP_ID);
        param.put("secret", WxemcpEntGlobals.WX_APP_SECRET);
        param.put("code", code);
        param.put("grant_type", "authorization_code");
        // String result = httpClientUtil.doPost(url, param, "UTF-8");
        HttpClientHelper httpHelper = HttpClientHelper.getInstance();
        String result = httpHelper.doPost(url, param);
        JSONObject json = JSONObject.fromObject(result);
        return json;
    }

}
