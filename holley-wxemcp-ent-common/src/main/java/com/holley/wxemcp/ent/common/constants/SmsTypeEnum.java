package com.holley.wxemcp.ent.common.constants;

/**
 * 短信类型
 */
public enum SmsTypeEnum {
    REMINDERFEE(1, "预付费催费"), VERIFICATIONCODE(2, "验证码"), REMINDERWATERFEE(3, "预付费水费催费"), ICM_REMINDERFEE(4, "卡表催费"), CLOSEMETER(5, "拉闸提醒"), ESAM_REMINDER_FEE(6, "esam卡表催费");

    private final int    value;
    private final String text;

    SmsTypeEnum(int value, String text) {
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
        SmsTypeEnum obj = getEnmuByValue(value);
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
    public static SmsTypeEnum getEnmuByValue(int value) {
        for (SmsTypeEnum record : SmsTypeEnum.values()) {
            if (record.getValue() == value) {
                return record;
            }
        }
        return null;
    }

}
