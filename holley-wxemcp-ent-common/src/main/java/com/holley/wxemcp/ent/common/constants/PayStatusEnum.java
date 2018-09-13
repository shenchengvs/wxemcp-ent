package com.holley.wxemcp.ent.common.constants;

/**
 * 支付状态
 */
public enum PayStatusEnum {
    UNPAID(0, "未支付"), SUCCESS(1, "成功"), FAIL(2, "失败");

    private final int    value;
    private final String text;

    PayStatusEnum(int value, String text) {
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
        PayStatusEnum task = getEnmuByValue(value);
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
    public static PayStatusEnum getEnmuByValue(int value) {
        for (PayStatusEnum record : PayStatusEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
