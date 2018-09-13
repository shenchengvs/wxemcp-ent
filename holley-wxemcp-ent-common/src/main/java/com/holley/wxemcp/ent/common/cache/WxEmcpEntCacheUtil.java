package com.holley.wxemcp.ent.common.cache;

import org.apache.commons.lang.SerializationUtils;

import com.holley.platform.common.dataobject.LoginCountBean;
import com.holley.platform.model.def.WebUser;
import com.holley.wxemcp.ent.common.constants.KeySessionTypeEnum;

/**
 * 光伏发电业务缓存
 * 
 * @author lenovo
 */
public class WxEmcpEntCacheUtil extends CacheCloudUtil {

    /**
     * 缓存存储图片验证码，3分钟内有效
     * 
     * @param jsessionId
     * @param code
     */
    public static void setImgValidateCode(String jsessionId, String code) {
        setString(CacheKeyProvide.getKey(CacheKeyProvide.KEY_WXEMCP_ENT_IMG_VALIDATE, jsessionId), code, EXRP_3M);
    }

    public static String getImgValidateCode(String jsessionId) {
        return getString(CacheKeyProvide.getKey(CacheKeyProvide.KEY_WXEMCP_ENT_IMG_VALIDATE, jsessionId));
    }

    public static String getPhoneCode(String phone) {
        return getString(CacheKeyProvide.getKey(CacheKeyProvide.KEY_WXSEND_CODE, phone));
    }

    public static void setPhoneCode(String phone, String code) {
        setString(CacheKeyProvide.getKey(CacheKeyProvide.KEY_WXSEND_CODE, phone), code, 600);
    }

    public static void removePhoneCode(String phone) {
        delKey(CacheKeyProvide.getKey(CacheKeyProvide.KEY_WXSEND_CODE, phone));
    }

    /**
     * 存储用户登录的信息，验证登录次数
     * 
     * @param bean
     * @return
     */
    public static boolean setLoginCount(String account, KeySessionTypeEnum type, LoginCountBean bean) {
        if (account == null || bean == null) {
            return false;
        }
        byte[] value = SerializationUtils.serialize(bean);
        String key = null;
        if (KeySessionTypeEnum.WXEMCP_ENT_WEB == type) {
            key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_WXEMCP_ENT_WEB_LOGIN_BEAN, account);
        } else {
            return false;
        }
        setByteEx(key.getBytes(), value, EXRP_30M);
        return true;
    }

    public static LoginCountBean getLoginCount(String account, KeySessionTypeEnum type) {
        if (account == null) {
            return null;
        }
        String key = null;
        if (KeySessionTypeEnum.WXEMCP_ENT_WEB == type) {
            key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_WXEMCP_ENT_WEB_LOGIN_BEAN, account);
        } else {
            return null;
        }
        byte[] value = getByte(key.getBytes());
        if (value != null) {
            return (LoginCountBean) SerializationUtils.deserialize(value);
        }
        return null;
    }

    public static boolean removeLoginCount(String account, KeySessionTypeEnum type) {
        if (account == null) {
            return false;
        }
        String key = null;
        if (KeySessionTypeEnum.WXEMCP_ENT_WEB == type) {
            key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_WXEMCP_ENT_WEB_LOGIN_BEAN, account);
        } else {
            return false;
        }
        return delKey(key.getBytes());
    }

    /**
     * 存储用户登录信息,30分钟失效
     * 
     * @param user
     * @return
     */
    public static boolean setSession(WebUser user, KeySessionTypeEnum type) {
        if (user == null) {
            return false;
        }
        String key = null;
        if (KeySessionTypeEnum.WXEMCP_ENT_WEB == type) {
            key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_WXEMCP_ENT_WEB_SESSION, user.getAccount());
        } else {
            return false;
        }
        setByte(key.getBytes(), SerializationUtils.serialize(user));
        expire(key.getBytes(), EXRP_30M);
        return true;
    }

    public static boolean haveSession(String account, KeySessionTypeEnum type) {
        if (account == null) {
            return false;
        }
        String key = null;
        if (KeySessionTypeEnum.WXEMCP_ENT_WEB == type) {
            key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_WXEMCP_ENT_WEB_SESSION, account);
        } else {
            return false;
        }
        byte[] objb = getByte(key.getBytes());
        return objb == null;
    }

    public static WebUser getSession(String account, KeySessionTypeEnum type) {
        if (account == null) {
            return null;
        }
        String key = null;
        if (KeySessionTypeEnum.WXEMCP_ENT_WEB == type) {
            key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_WXEMCP_ENT_WEB_SESSION, account);
        } else {
            return null;
        }
        byte[] objb = getByte(key.getBytes());
        if (objb != null) {
            return (WebUser) SerializationUtils.deserialize(objb);
        }
        return null;
    }

    public static void removieSession(String account, KeySessionTypeEnum type) {
        String key = null;
        if (KeySessionTypeEnum.WXEMCP_ENT_WEB == type) {
            key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_WXEMCP_ENT_WEB_SESSION, account);
        } else {
            return;
        }
        delKey(key);
    }

}
