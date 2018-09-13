package com.holley.wxemcp.ent.common.constants;

import org.apache.commons.lang3.StringUtils;

/**
 * 数据类型
 * 
 * @author armording
 */
public enum EventDataTypeEnum {
    ENERGY(0, "电量"), POWER(1, "功率"), CURRENT(2, "电流");

    private final int    value;
    private final String text;

    EventDataTypeEnum(int value, String text) {
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
        EventDataTypeEnum em = getEnmuByValue(value);
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
    public static EventDataTypeEnum getEnmuByValue(int value) {
        for (EventDataTypeEnum et : EventDataTypeEnum.values()) {
            if (value == et.getValue()) {
                return et;
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
    public static EventDataTypeEnum getEnmuByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        for (EventDataTypeEnum et : EventDataTypeEnum.values()) {
            if (StringUtils.equals(name, et.toString())) {
                return et;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return text;
    }

}
