package com.holley.wxemcp.ent.common.constants;

/**
 * 用电性质Industrial
 */
public enum ElectricityTypeEnum {
    LIFE(1, "居民生活用电"), NOMAL_BUS(2, "一般工商业用电"), INDUSTIAL(3, "大工业用电"), AGRICULTURE_PRO(4, "农业生产用电"), AGRICULTURE_DRA(5, "农业排灌用电"), OTHER(6, "其他");

    private final int    value;
    private final String text;

    ElectricityTypeEnum(int value, String text) {
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
        ElectricityTypeEnum obj = getEnmuByValue(value);
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
    public static ElectricityTypeEnum getEnmuByValue(int value) {
        for (ElectricityTypeEnum record : ElectricityTypeEnum.values()) {
            if (record.getValue() == value) {
                return record;
            }
        }
        return null;
    }

}
