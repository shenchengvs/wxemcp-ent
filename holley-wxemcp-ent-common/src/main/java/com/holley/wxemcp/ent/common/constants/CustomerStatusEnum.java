package com.holley.wxemcp.ent.common.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * 预付费用户状态
 */
public enum CustomerStatusEnum {
    DELETE(-1, "被删除"), RUNING(1, "运行"), CANCEL(2, "销户"), TEST(3, "调试"), PAUSE(4, "暂停");

    private final int    value;
    private final String text;

    CustomerStatusEnum(int value, String text) {
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
        CustomerStatusEnum obj = getEnmuByValue(value);
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
    public static CustomerStatusEnum getEnmuByValue(int value) {
        for (CustomerStatusEnum record : CustomerStatusEnum.values()) {
            if (record.getValue() == value) {
                return record;
            }
        }
        return null;
    }

    public static List<CustomerStatusEnum> getCustomerStatusList() {
        List<CustomerStatusEnum> list = new ArrayList<CustomerStatusEnum>();
        list.add(CustomerStatusEnum.RUNING);
        list.add(CustomerStatusEnum.CANCEL);
        list.add(CustomerStatusEnum.TEST);
        list.add(CustomerStatusEnum.PAUSE);
        return list;
    }

}
