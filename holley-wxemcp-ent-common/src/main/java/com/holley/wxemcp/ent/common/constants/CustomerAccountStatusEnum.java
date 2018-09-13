package com.holley.wxemcp.ent.common.constants;

/**
 * 预付费用户状态
 */
public enum CustomerAccountStatusEnum {
    ACTIVE(1, "激活"), FROZEN(2, "冻结");

    private final int    value;
    private final String text;

    CustomerAccountStatusEnum(int value, String text) {
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
        CustomerAccountStatusEnum obj = getEnmuByValue(value);
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
    public static CustomerAccountStatusEnum getEnmuByValue(int value) {
        for (CustomerAccountStatusEnum record : CustomerAccountStatusEnum.values()) {
            if (record.getValue() == value) {
                return record;
            }
        }
        return null;
    }

}
