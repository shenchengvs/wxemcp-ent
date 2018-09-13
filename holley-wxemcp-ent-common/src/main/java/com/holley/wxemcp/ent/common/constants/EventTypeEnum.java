package com.holley.wxemcp.ent.common.constants;

import org.apache.commons.lang3.StringUtils;

/**
 * 0-横向同比<br>
 * 1-纵向同比<br>
 * 2-负载率<br>
 * 3-电平衡<br>
 * 4-预付费催费<br>
 * 5-预付费拉闸<br>
 * 
 * @author armording
 */
public enum EventTypeEnum {
    HRATIO(0, "横向同比"), VRATIO(1, "纵向同比"), LOADRATE(2, "负载率"), POWERBALANCE(3, "电平衡"), PREPAY_URGEFEE(4, "预付费催费"), PREPAY_DISCONNECT(5, "预付费拉闸");

    private final int    value;
    private final String text;

    EventTypeEnum(int value, String text) {
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
        EventTypeEnum em = getEnmuByValue(value);
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
    public static EventTypeEnum getEnmuByValue(int value) {
        for (EventTypeEnum et : EventTypeEnum.values()) {
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
    public static EventTypeEnum getEnmuByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        for (EventTypeEnum et : EventTypeEnum.values()) {
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
