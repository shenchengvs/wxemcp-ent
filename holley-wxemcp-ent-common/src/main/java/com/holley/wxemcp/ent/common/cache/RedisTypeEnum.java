package com.holley.wxemcp.ent.common.cache;

public enum RedisTypeEnum {
    STANDALONE("redis-standalone"), SENTINEL("redis-sentinel"), CLUSTER("redis-cluster");

    private final String value;

    RedisTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    /**
     * 通过传入的字符串匹配枚举，传入值
     *
     * @param value
     * @return
     */
    public static RedisTypeEnum getEnmuByValue(String value) {
        for (RedisTypeEnum at : RedisTypeEnum.values()) {
            if (at.getValue() == value) {
                return at;
            }
        }
        return null;
    }
}
