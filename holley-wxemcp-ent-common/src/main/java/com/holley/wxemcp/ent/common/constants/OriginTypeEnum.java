package com.holley.wxemcp.ent.common.constants;

public enum OriginTypeEnum {
    WEB(1, "网站"), MOBILE(2, "移动");

    private final int    value;
    private final String text;

    OriginTypeEnum(int value, String text) {
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
    public static OriginTypeEnum getEnmuByValue(int value) {
        for (OriginTypeEnum at : OriginTypeEnum.values()) {
            if (at.getValue() == value) {
                return at;
            }
        }
        return null;
    }
}
