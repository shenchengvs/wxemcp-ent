package com.holley.wxemcp.ent.common.constants;

/**
 * 电费核对状态<br>
 * ppf_customer_fee_month表的status字段
 */
public enum FeeCheckStatusEnum {
                                UNCHECKED(1, "未核算"), CHECKED(2, "已核算");

    private final int    value;
    private final String text;

    FeeCheckStatusEnum(int value, String text) {
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
        FeeCheckStatusEnum obj = getEnmuByValue(value);
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
    public static FeeCheckStatusEnum getEnmuByValue(int value) {
        for (FeeCheckStatusEnum record : FeeCheckStatusEnum.values()) {
            if (record.getValue() == value) {
                return record;
            }
        }
        return null;
    }

}
