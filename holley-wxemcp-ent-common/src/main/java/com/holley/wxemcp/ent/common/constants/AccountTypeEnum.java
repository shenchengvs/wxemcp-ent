package com.holley.wxemcp.ent.common.constants;

public enum AccountTypeEnum {
    ENTERPRISE(1, "企业管理员"), OPERATOR(2, "企业操作员"), PLATFORM(3, "平台管理员"), BUSINESS(4, "运营商管理员");

    private final int    value;
    private final String text;

    AccountTypeEnum(int value, String text) {
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
    public static AccountTypeEnum getEnmuByValue(int value) {
        for (AccountTypeEnum at : AccountTypeEnum.values()) {
            if (at.getValue() == value) {
                return at;
            }
        }
        return null;
    }
}
