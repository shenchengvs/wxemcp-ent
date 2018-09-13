package com.holley.wxemcp.ent.common.constants;

/**
 * 信息发送方式
 */
public enum SendMsgTypeEnum {
    AUTO(1, "自动"), MANUAL(2, "手动");

    private final int    value;
    private final String text;

    SendMsgTypeEnum(int value, String text) {
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
        SendMsgTypeEnum obj = getEnmuByValue(value);
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
    public static SendMsgTypeEnum getEnmuByValue(int value) {
        for (SendMsgTypeEnum record : SendMsgTypeEnum.values()) {
            if (record.getValue() == value) {
                return record;
            }
        }
        return null;
    }

}
