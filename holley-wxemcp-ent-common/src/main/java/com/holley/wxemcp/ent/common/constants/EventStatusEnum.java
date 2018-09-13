package com.holley.wxemcp.ent.common.constants;

import org.apache.commons.lang3.StringUtils;

/**
 * 0-恢复<br>
 * 1-发生<br>
 * 
 * @author zdd
 */
public enum EventStatusEnum {

    RECOVER(0, "恢复"), HAPPEN(1, "发生");

    private final int    value;
    private final String text;

    EventStatusEnum(int value, String text) {
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
        EventStatusEnum em = getEnmuByValue(value);
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
    public static EventStatusEnum getEnmuByValue(int value) {
        for (EventStatusEnum et : EventStatusEnum.values()) {
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
    public static EventStatusEnum getEnmuByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        for (EventStatusEnum et : EventStatusEnum.values()) {
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
