package com.holley.wxemcp.ent.common.constants;

/**
 * 返回结果类型 <br>
 */
public enum RetTypeEnum {
    SYS_BUSY(-1, "系统繁忙"), SUCCESS(0, "请求成功"), USER_ERROR(1, "未知用户"), PARAM_ERROR(2, "请求参数非法"), PASSWORD_ERROR(3, "账号或密码错误"), SYS_ERROR(500, "系统错误");

    private final int    value;
    private final String text;

    RetTypeEnum(int value, String text) {
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
        RetTypeEnum task = getEnmuByValue(value);
        return task == null ? null : task.getText();
    }

    public Short getShortValue() {
        Integer obj = value;
        return obj.shortValue();
    }

    /**
     * 通过传入的值匹配枚举
     * 
     * @param value
     * @return
     */
    public static RetTypeEnum getEnmuByValue(int value) {
        for (RetTypeEnum record : RetTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
