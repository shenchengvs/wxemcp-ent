package com.holley.wxemcp.ent.common;

import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;

import com.holley.emcp.sms.model.PpfSmsSend;
import com.holley.platform.common.cache.RedisUtil;
import com.holley.wxemcp.ent.common.cache.CacheCloudUtil;
import com.holley.wxemcp.ent.common.cache.CacheKeyProvide;

public class SmsSendUtil {

    public static void sendMsg(PpfSmsSend sms) {

        RedisUtil.lpush(CacheKeyProvide.KEY_CODE_SMS_LIST.getBytes(), SerializationUtils.serialize((Serializable) sms));
    }

    public static void sendMsgCloud(PpfSmsSend sms) {
        CacheCloudUtil.lpush(CacheKeyProvide.KEY_CODE_SMS_LIST.getBytes(), SerializationUtils.serialize((Serializable) sms));
    }
}
