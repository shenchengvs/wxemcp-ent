package com.holley.wxemcp.ent.common.constants;

/**
 * 支付方式
 */
public enum PayWayTypeEnum {
    WEB(1, "线下支付"), ALIPAY(2, "支付宝"), WECHAT(3, "微信"), INTERFACE(4, "接口");

    private final int    value;
    private final String text;

    PayWayTypeEnum(int value, String text) {
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
        PayWayTypeEnum task = getEnmuByValue(value);
        return task == null ? null : task.getText();
    }

    public Short getShortValue() {
        Integer obj = value;
        return obj.shortValue();
    }

    /**
     * 通过传入的值匹配枚举
     * 
     * @param value
     * @return
     */
    public static PayWayTypeEnum getEnmuByValue(int value) {
        for (PayWayTypeEnum record : PayWayTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
