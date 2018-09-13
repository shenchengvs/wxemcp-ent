package com.holley.wxemcp.ent.common.constants;

import org.apache.commons.lang3.StringUtils;

/**
 * 0-15分钟<br>
 * 1-小时<br>
 * 2-日<br>
 * 3-月<br>
 * 4-季<br>
 * 6-周<br>
 * 7-年<br>
 * 
 * @author armording
 */

public enum CircleTypeEnum {

    MINUTE(0, "分钟"), HOUR(1, "小时"), DAY(2, "日"), MONTH(3, "月"), WEEK(4, "周"), QUARTER(6, "季"), YEAR(7, "年"), ZDY(8, "自定义");

    private final int    value;
    private final String text;

    CircleTypeEnum(int value, String text) {
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
    public static CircleTypeEnum getEnmuByValue(int value) {
        for (CircleTypeEnum lowCommType : CircleTypeEnum.values()) {
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
    public static CircleTypeEnum getEnmuByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        for (CircleTypeEnum lowCommType : CircleTypeEnum.values()) {
            if (StringUtils.equals(name, lowCommType.toString())) {
                return lowCommType;
            }
        }
        return null;
    }

    /**
     * 通过传入的值匹配枚举，返回名称
     * 
     * @param value
     * @return
     */
    public static String getText(int value) {
        CircleTypeEnum em = getEnmuByValue(value);
        return em == null ? null : em.getText();
    }
}
