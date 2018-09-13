package com.holley.wxemcp.ent.common.constants;

/**
 * 预付费类型
 */
public enum FeeTypeEnum {
    SINGLE(1, "独享"), SHARE(2, "分摊");

    private final int    value;
    private final String text;

    FeeTypeEnum(int value, String text) {
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
        FeeTypeEnum obj = getEnmuByValue(value);
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
    public static FeeTypeEnum getEnmuByValue(int value) {
        for (FeeTypeEnum record : FeeTypeEnum.values()) {
            if (record.getValue() == value) {
                return record;
            }
        }
        return null;
    }

}
