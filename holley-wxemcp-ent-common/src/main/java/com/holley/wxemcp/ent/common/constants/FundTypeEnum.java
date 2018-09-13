package com.holley.wxemcp.ent.common.constants;

/**
 * 欠费状态
 */
public enum FundTypeEnum {
    FUND1(1, "农网还贷资金"), FUND2(2, "国家重大水利工程建设基金"), FUND3(3, "城市公用事业附加费"), FUND4(4, "大中型水库移民后期扶持资金"), FUND5(5, "地方水库移民后期扶持资金"), FUND6(6, "可再生能源电价附加");

    private final int    value;
    private final String text;

    FundTypeEnum(int value, String text) {
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
        FundTypeEnum obj = getEnmuByValue(value);
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
    public static FundTypeEnum getEnmuByValue(int value) {
        for (FundTypeEnum record : FundTypeEnum.values()) {
            if (record.getValue() == value) {
                return record;
            }
        }
        return null;
    }

}
