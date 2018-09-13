package com.holley.wxemcp.ent.common.constants;

/**
 * 拉闸方式
 */
public enum CmdTypeEnum {
    DISCONNECT(1, "拉闸"), CONNECT(2, "合闸");

    private final int    value;
    private final String text;

    CmdTypeEnum(int value, String text) {
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
        CmdTypeEnum obj = getEnmuByValue(value);
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
    public static CmdTypeEnum getEnmuByValue(int value) {
        for (CmdTypeEnum record : CmdTypeEnum.values()) {
            if (record.getValue() == value) {
                return record;
            }
        }
        return null;
    }

}
