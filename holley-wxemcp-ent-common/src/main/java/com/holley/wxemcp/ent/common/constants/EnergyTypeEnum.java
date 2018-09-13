package com.holley.wxemcp.ent.common.constants;

import org.apache.commons.lang3.StringUtils;

/**
 * 1-电<br>
 * 2-水<br>
 * 
 * @author armording
 */
public enum EnergyTypeEnum {

    POWER(1, "电力"), WATER(2, "水");

    private final int    value;
    private final String text;

    EnergyTypeEnum(int value, String text) {
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
        EnergyTypeEnum em = getEnmuByValue(value);
        return em == null ? null : em.getText();
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
    public static EnergyTypeEnum getEnmuByValue(int value) {
        for (EnergyTypeEnum lowCommType : EnergyTypeEnum.values()) {
            if (value == lowCommType.getValue()) {
                return lowCommType;
            }
        }
        return null;
    }

    /**
     * 通过传入的字符串匹配枚举,传入名字
     * 
     * @param name
     * @return
     */
    public static EnergyTypeEnum getEnmuByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        for (EnergyTypeEnum lowCommType : EnergyTypeEnum.values()) {
            if (StringUtils.equals(name, lowCommType.toString())) {
                return lowCommType;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return text;
    }

}
