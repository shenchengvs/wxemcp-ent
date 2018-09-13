package com.holley.wxemcp.ent.common.constants;

/**
 * 电表运行状态
 */
public enum MeterPowerStatusEnum {
    POWER_ON(0, "通电"), POWER_OFF(1, "断电");

    private final int    value;
    private final String text;

    MeterPowerStatusEnum(int value, String text) {
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
        MeterPowerStatusEnum obj = getEnmuByValue(value);
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
    public static MeterPowerStatusEnum getEnmuByValue(int value) {
        for (MeterPowerStatusEnum record : MeterPowerStatusEnum.values()) {
            if (record.getValue() == value) {
                return record;
            }
        }
        return null;
    }

}
