package com.holley.wxemcp.ent.common.constants;

/**
 * 电费明细状态 <br>
 * ppf_customer_fee_month_detail表的status字段
 */
public enum FeeDetailStatusEnum {
                                 UNBILL(1, "未结算"), BUDGETED(2, "已结算");

    private final int    value;
    private final String text;

    FeeDetailStatusEnum(int value, String text) {
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
        FeeDetailStatusEnum obj = getEnmuByValue(value);
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
    public static FeeDetailStatusEnum getEnmuByValue(int value) {
        for (FeeDetailStatusEnum record : FeeDetailStatusEnum.values()) {
            if (record.getValue() == value) {
                return record;
            }
        }
        return null;
    }

}
