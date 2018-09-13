package com.holley.wxemcp.ent.common.constants;

/**
 * 推送按钮显示状态
 */
public enum WxPushIsShowTypeEnum {
    SHOW(1, "显示"), UN_SHOW(2, "不显示");

    private final int    value;
    private final String text;

    WxPushIsShowTypeEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public static String getText(int value) {
        WxPushIsShowTypeEnum obj = getEnmuByValue(value);
        return obj == null ? null : obj.getText();
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
    public static WxPushIsShowTypeEnum getEnmuByValue(int value) {
        for (WxPushIsShowTypeEnum record : WxPushIsShowTypeEnum.values()) {
            if (record.getValue() == value) {
                return record;
            }
        }
        return null;
    }

}
