package com.holley.wxemcp.ent.common.constants;

import org.apache.commons.lang3.StringUtils;

/**
 * 费率类型
 * 
 * @author Armording
 */
public enum TarrifTypeEnum {
    TARRIF_ZONG(0, "总"), TARRIF_JIAN(1, "尖"), TARRIF_FENG(2, "峰"), TARRIF_PING(3, "平"), TARRIF_GU(4, "谷");

    private final int    value;
    private final String text;

    TarrifTypeEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public Short getShortValue() {
        return new Short((short) value);
    }

    public String getText() {
        return text;
    }

    public static String getText(int value) {
        TarrifTypeEnum task = getEnmuByValue(value);
        return task == null ? "" : task.getText();
    }

    /**
     * 通过传入的字符串匹配枚举，传入值
     * 
     * @param value
     * @return
     */
    public static TarrifTypeEnum getEnmuByValue(int value) {
        for (TarrifTypeEnum tarrifType : TarrifTypeEnum.values()) {
            if (value == tarrifType.getValue()) {
                return tarrifType;
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
    public static TarrifTypeEnum getEnmuByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        for (TarrifTypeEnum tarrifType : TarrifTypeEnum.values()) {
            if (StringUtils.equals(name, tarrifType.toString())) {
                return tarrifType;
            }
        }
        return null;
    }
}
