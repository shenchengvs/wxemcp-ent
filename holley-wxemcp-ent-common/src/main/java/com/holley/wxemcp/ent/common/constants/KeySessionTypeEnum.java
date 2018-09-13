package com.holley.wxemcp.ent.common.constants;

import org.apache.commons.lang3.StringUtils;

/**
 * 设备档案状态
 * 
 * @author sc
 */
public enum KeySessionTypeEnum {
    WXEMCP_ENT_WEB(1, "企业微信");

    private final int    value;
    private final String text;

    KeySessionTypeEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public Short getShortValue() {
        return ((Integer) value).shortValue();
    }

    public String getText() {
        return text;
    }

    /**
     * 通过传入的字符串匹配枚举，传入值
     * 
     * @param value
     * @return
     */
    public static KeySessionTypeEnum getEnmuByValue(int value) {
        for (KeySessionTypeEnum powerType : KeySessionTypeEnum.values()) {
            if (value == powerType.getValue()) {
                return powerType;
            }
        }
        return null;
    }

    /**
     * 通过传入的字符串匹配枚举,传入名字
     * 
     * @param name
     * @return
     */
    public static KeySessionTypeEnum getEnmuByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        for (KeySessionTypeEnum powerType : KeySessionTypeEnum.values()) {
            if (StringUtils.equals(name, powerType.toString())) {
                return powerType;
            }
        }
        return null;
    }
}
