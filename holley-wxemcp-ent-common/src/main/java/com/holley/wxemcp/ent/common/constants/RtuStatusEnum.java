package com.holley.wxemcp.ent.common.constants;

/**
 * 终端状态
 */
public enum RtuStatusEnum {
    OFFLINE(0, "离线"), ONLINE(1, "在线");

    private final int    value;
    private final String text;

    RtuStatusEnum(int value, String text) {
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
        RtuStatusEnum obj = getEnmuByValue(value);
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
    public static RtuStatusEnum getEnmuByValue(int value) {
        for (RtuStatusEnum record : RtuStatusEnum.values()) {
            if (record.getValue() == value) {
                return record;
            }
        }
        return null;
    }

}
