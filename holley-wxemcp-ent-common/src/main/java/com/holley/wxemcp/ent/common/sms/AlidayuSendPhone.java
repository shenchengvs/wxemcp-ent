package com.holley.wxemcp.ent.common.sms;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.holley.platform.common.util.JsonUtil;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

/**
 * 阿里大鱼短信发送
 * 
 * @author sc
 */
public class AlidayuSendPhone {

    private final static Logger        logger           = Logger.getLogger(AlidayuSendPhone.class);
    private static String              APP_KEY          = "23393511";
    private static String              APP_SECRET       = "1957e25bdc0b14faffa71c63cdbcd163";
    private static String              SEND_URL         = "http://gw.api.taobao.com/router/rest";  // 短信接口地址
    private static String              SMS_TYPE         = "normal";                                // 短信类型默认normal（普通）
    private static String              TEMPLATE_CODE    = "templatecode";                          // 验证码模板
    private static String              TEMPLATE_VERIFY  = "templateverify";                        // 审核通知模版
    private static String              TEMPLATE_ACCOUNT = "templateaccount";                       // 账户通知模版
    private static String              SIGN_TITLE       = "华立能管家";                                 // 验证码签名名称
    private static JSONObject          TEMPLATEJSON     = null;                                    // 短信模版
    private static Map<String, Object> PARAMS           = new HashMap<String, Object>();

    public static void init(String appKey, String appSecret, String sendUrl, String template, String signTitle) {
        APP_KEY = appKey;
        APP_SECRET = appSecret;
        SEND_URL = sendUrl;
        SIGN_TITLE = signTitle;
        TEMPLATEJSON = JSONObject.fromObject(template);
    }

    /**
     * 验证通知 <br>
     * 模板类型:验证码<br>
     * 模板名称:身份验证验证码<br>
     * 模板ID:SMS_11060163<br>
     * 模板内容:验证码${code}，您正在进行${product}身份验证，打死不要告诉别人哦！<br>
     */
    public static boolean sendCodeMsg(String phone, String code) {
        if (TEMPLATEJSON == null) {
            return false;
        }
        PARAMS.clear();
        PARAMS.put("product", "51充电");
        PARAMS.put("code", code);
        String content = JsonUtil.map2json(PARAMS);
        return baseMsg(phone, content, SIGN_TITLE, TEMPLATEJSON.getString(TEMPLATE_CODE));
    }

    /**
     * 审核结果通知 <br>
     * 模板类型:短信通知 <br>
     * 模板名称:审核通知 <br>
     * 模板ID:SMS_12861800 <br>
     * 模板内容:尊敬的用户：您好！${content}审核${result}，请注意查看。
     */
    public static boolean sendVerifyMsg(String phone, String content, String result) {
        if (TEMPLATEJSON == null) {
            return false;
        }
        PARAMS.clear();
        PARAMS.put("content", content);
        PARAMS.put("result", result);
        String msg = JsonUtil.map2json(PARAMS);
        logger.info("-----短信发送-----phone=" + phone + "----尊敬的用户：您好！" + content + "审核" + result + "，请注意查看。");
        return baseMsg(phone, msg, SIGN_TITLE, TEMPLATEJSON.getString(TEMPLATE_VERIFY));
    }

    /**
     * 平台人工充值通知 <br>
     * 模板类型:短信通知 <br>
     * 模板名称:账户通知 <br>
     * 模板ID:SMS_12992988<br>
     * 模板内容:您账户${content}，可用余额${usablemoney}。
     */
    public static boolean sendAccountMsg(String phone, String content, String usablemoney) {
        if (TEMPLATEJSON == null) {
            return false;
        }
        PARAMS.clear();
        PARAMS.put("content", content);
        PARAMS.put("usablemoney", usablemoney);
        String msg = JsonUtil.map2json(PARAMS);
        logger.info("-----短信发送-----phone=" + phone + "----短信内容----" + content + "，可用余额" + usablemoney + "。");
        return baseMsg(phone, msg, SIGN_TITLE, TEMPLATEJSON.getString(TEMPLATE_ACCOUNT));
    }

    private static boolean baseMsg(String phone, String content, String signName, String templateCode) {
        if (StringUtils.isEmpty(templateCode)) {
            return false;
        }
        boolean result = false;
        String resultMsg = "";
        TaobaoClient client = new DefaultTaobaoClient(SEND_URL, APP_KEY, APP_SECRET);
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setExtend("");
        req.setSmsType(SMS_TYPE);
        req.setSmsFreeSignName(signName);
        req.setSmsParamString(content);
        req.setRecNum(phone);
        req.setSmsTemplateCode(templateCode);
        AlibabaAliqinFcSmsNumSendResponse rsp;
        try {
            rsp = client.execute(req);
            resultMsg = rsp.getBody();
            System.out.println(resultMsg);
            if (JSONObject.fromObject(resultMsg).get("alibaba_aliqin_fc_sms_num_send_response") != null) {
                result = true;
            }
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void sendPhoneCode(String phone, String code) {
        PARAMS.clear();
        PARAMS.put("product", "e能家园");
        PARAMS.put("code", code);
        baseMsg(phone, JsonUtil.map2json(PARAMS), SIGN_TITLE, "SMS_11060163");
    }

    public static void main(String[] args) {

        // PARAMS.put("content", "水电周转金收据");
        // PARAMS.put("address", "物业");
        // PARAMS.put("entname", "天福财智大厦物管中心");SMS_11060163
        sendPhoneCode("13777862839", "3214");
        // 金沙国际业主您好！方便抄表和缴费，电力智能系统已改造升级，于2018年1月1日启用。请务必于2017年12月31日前携带水电周转金收据来物业注册登记（0571-87910365）。天福财智大厦物管中心
        // 各位业主您好！方便抄表和缴费，电力智能系统已改造升级，于2018年1月1日启用。请务必于2017年12月31日前携带${content}来${address}注册登记（0571-87910365）。${entname}为您服务。
    }
}
