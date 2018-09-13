package com.holley.wxemcp.ent.common.constants;

public enum LoginStatusTypeEnum {
    LOGIN(1, "登陆"), UN_LOGIN(2, "未登录");

    private final int    value;
    private final String text;

    LoginStatusTypeEnum(int value, String text) {
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
    public static LoginStatusTypeEnum getEnmuByValue(int value) {
        for (LoginStatusTypeEnum at : LoginStatusTypeEnum.values()) {
            if (at.getValue() == value) {
                return at;
            }
        }
        return null;
    }
}
