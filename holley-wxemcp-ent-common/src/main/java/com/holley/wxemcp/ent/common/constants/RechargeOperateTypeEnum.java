package com.holley.wxemcp.ent.common.constants;

/**
 * 充值业务操作类型
 */
public enum RechargeOperateTypeEnum {
    RECHARGE(1, "线下充值"), SUBTRACT_RECHARGE(2, "退回充值");

    private final int    value;
    private final String text;

    RechargeOperateTypeEnum(int value, String text) {
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
        RechargeOperateTypeEnum task = getEnmuByValue(value);
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
    public static RechargeOperateTypeEnum getEnmuByValue(int value) {
        for (RechargeOperateTypeEnum record : RechargeOperateTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
