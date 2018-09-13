package com.holley.wxemcp.ent.common.constants;

public enum WxPushStatusTypeEnum {
    PUSH(1, "推送"), UN_PUSH(2, "不推送");

    private final int    value;
    private final String text;

    WxPushStatusTypeEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public Short getShortValue() {
        Integer obj = value;
        return obj.shortValue();
    }

    /**
     * 通过传入的字符串匹配枚举，传入值
     * 
     * @param value
     * @return
     */
    public static WxPushStatusTypeEnum getEnmuByValue(int value) {
        for (WxPushStatusTypeEnum at : WxPushStatusTypeEnum.values()) {
            if (at.getValue() == value) {
                return at;
            }
        }
        return null;
    }
}
