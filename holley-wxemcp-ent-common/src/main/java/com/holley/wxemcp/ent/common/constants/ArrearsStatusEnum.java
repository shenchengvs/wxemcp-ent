package com.holley.wxemcp.ent.common.constants;

/**
 * 欠费状态
 */
public enum ArrearsStatusEnum {
    NORMAL(1, "正常"), REMINDER_FEE(2, "催费"), ARREARS(3, "欠费");

    private final int    value;
    private final String text;

    ArrearsStatusEnum(int value, String text) {
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
        ArrearsStatusEnum obj = getEnmuByValue(value);
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
    public static ArrearsStatusEnum getEnmuByValue(int value) {
        for (ArrearsStatusEnum record : ArrearsStatusEnum.values()) {
            if (record.getValue() == value) {
                return record;
            }
        }
        return null;
    }

}
