package com.holley.wxemcp.ent.common.constants;

/**
 * 预付费用户类型
 */
public enum CustomerTypeEnum {
    PERSON(1, "个人用户"), COMPANY(2, "公司用户");

    private final int    value;
    private final String text;

    CustomerTypeEnum(int value, String text) {
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
        CustomerTypeEnum obj = getEnmuByValue(value);
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
    public static CustomerTypeEnum getEnmuByValue(int value) {
        for (CustomerTypeEnum record : CustomerTypeEnum.values()) {
            if (record.getValue() == value) {
                return record;
            }
        }
        return null;
    }

}
