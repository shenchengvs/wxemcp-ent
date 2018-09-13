package com.holley.wxemcp.ent.common.constants;

/**
 * 企业类型
 */
public enum EnterpriseTypeEnum {
    PLATFORM(0, "平台"), PARK(1, "园区"), PREPAY(2, "费控"), AGENT(3, "代理商");

    private final int    value;
    private final String text;

    EnterpriseTypeEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    /**
     * 通过传入的字符串匹配枚举，传入值
     * 
     * @param value
     * @return
     */
    public static EnterpriseTypeEnum getEnmuByValue(int value) {
        for (EnterpriseTypeEnum at : EnterpriseTypeEnum.values()) {
            if (at.getValue() == value) {
                return at;
            }
        }
        return null;
    }

    /**
     * 通过传入的字符串匹配枚举获得描述，传入值
     * 
     * @param value
     * @return
     */
    public static String getText(int value) {
        EnterpriseTypeEnum type = getEnmuByValue(value);
        return type == null ? "" : type.text;
    }

    public Short getShortValue() {
        Integer obj = value;
        return obj.shortValue();
    }

}
