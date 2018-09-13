package com.holley.wxemcp.ent.common.constants;

/**
 * 拉合闸命令结果
 */
public enum CmdResultEnum {
    SENDING(0, "未下发"), SUCCESS(1, "成功"), FAILURE(2, "失败");

    private final int    value;
    private final String text;

    CmdResultEnum(int value, String text) {
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
        CmdResultEnum obj = getEnmuByValue(value);
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
    public static CmdResultEnum getEnmuByValue(int value) {
        for (CmdResultEnum record : CmdResultEnum.values()) {
            if (record.getValue() == value) {
                return record;
            }
        }
        return null;
    }

}
