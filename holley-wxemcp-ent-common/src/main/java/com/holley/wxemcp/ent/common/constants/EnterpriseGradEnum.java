package com.holley.wxemcp.ent.common.constants;

public enum EnterpriseGradEnum {

                                STATEREGULATION(1, "国家监管"), PROVINCIALREGULATION(2, "省级监管"), LOCALREGULATION(3, "各地市监管");

    private final int    value;
    private final String text;

    EnterpriseGradEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
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
    public static EnterpriseGradEnum getEnmuByValue(int value) {
        for (EnterpriseGradEnum at : EnterpriseGradEnum.values()) {
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
        EnterpriseGradEnum type = getEnmuByValue(value);
        return type == null ? "" : type.text;
    }

}
