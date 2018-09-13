package com.holley.wxemcp.ent.common.constants;

/**
 * 追退费类型
 */
public enum FeeChangeTypeEnum {
    ADD_FEE(1, "追加费用"), SUBTRACT_FEE(2, "退回费用"), SUBTRACT_RECHARGE(3, "退回充值"), FREEZE_CLEAR(4, "冻结清零"), ACCOUNT_CLEAR(5, "账户清零");

    private final int    value;
    private final String text;

    FeeChangeTypeEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public static String getText(int value, Short energytype) {
        FeeChangeTypeEnum obj = getEnmuByValue(value);
        if (energytype == EnergyTypeEnum.POWER.getShortValue()) {
            return obj == null ? null : obj.getText() + "(电费)";
        } else if (energytype == EnergyTypeEnum.WATER.getShortValue()) {
            return obj == null ? null : obj.getText() + "(水费)";
        }
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
    public static FeeChangeTypeEnum getEnmuByValue(int value) {
        for (FeeChangeTypeEnum record : FeeChangeTypeEnum.values()) {
            if (record.getValue() == value) {
                return record;
            }
        }
        return null;
    }

}
