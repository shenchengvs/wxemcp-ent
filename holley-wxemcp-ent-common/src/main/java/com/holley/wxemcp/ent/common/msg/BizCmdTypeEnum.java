package com.holley.wxemcp.ent.common.msg;


import org.apache.commons.lang3.StringUtils;

public enum BizCmdTypeEnum {
    REPORTCYC(0), STATIONIP(1), RTUIP(2), POINTPARA(3),CURRENTDATA(4),HISDATA(5),HISWORKSTATUS(6), POINTPARALIST(7),
    REPORTCYC_READ(10), STATIONIP_READ(11), RTUIP_READ(12), POINTPARA_READ(13),PARASET_RESULT(14),SOFT_UPDATE(15);

    private final int value;

    BizCmdTypeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
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
    public static BizCmdTypeEnum getEnmuByValue(int value) {
        for (BizCmdTypeEnum lowCommType : BizCmdTypeEnum.values()) {
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
    public static BizCmdTypeEnum getEnmuByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        for (BizCmdTypeEnum lowCommType : BizCmdTypeEnum.values()) {
            if (StringUtils.equals(name, lowCommType.toString())) {
                return lowCommType;
            }
        }
        return null;
    }
}
