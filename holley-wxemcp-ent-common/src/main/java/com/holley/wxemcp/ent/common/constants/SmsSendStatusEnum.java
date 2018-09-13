package com.holley.wxemcp.ent.common.constants;

/**
 * 短信发送状态
 */
public enum SmsSendStatusEnum {
    SENDING(0, "未发送"), SUCCESS(1, "成功"), FAILURE(2, "失败");

    private final int    value;
    private final String text;

    SmsSendStatusEnum(int value, String text) {
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
        SmsSendStatusEnum obj = getEnmuByValue(value);
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
    public static SmsSendStatusEnum getEnmuByValue(int value) {
        for (SmsSendStatusEnum record : SmsSendStatusEnum.values()) {
            if (record.getValue() == value) {
                return record;
            }
        }
        return null;
    }

}
