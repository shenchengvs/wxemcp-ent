package com.holley.wxemcp.ent.common.cache;

/**
 * 缓存主键定义规则
 * 
 * @author sc
 */
public class CacheKeyProvide {

    public static String KEY_WXEMCP_ENT_IMG_VALIDATE   = "keyWxemcpEntImgValidate_"; // 图片验证码

    public static String KEY_WXEMCP_ENT_WEB_LOGIN_BEAN = "keyWxemcpEntWebLoginBean_"; // 用户登录失败次数

    public static String KEY_WXEMCP_ENT_WEB_SESSION    = "keyWxemcpEntWebSession_";  // 登录session
    public static String KEY_WXSEND_CODE               = "keyWxsendCode_";           // 登录session
    public static String KEY_FEE_SMS_LIST              = "key_fee_sms_list";

    public static String KEY_CODE_SMS_LIST             = "key_code_sms_list";

    public static String getKey(String suffex, String key) {
        return suffex + key;
    }

}
