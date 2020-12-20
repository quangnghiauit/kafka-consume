package com.dacn.kafkadatalake.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum TransStatusEnum {

    SUCCESSFUL(1),
    EXCEPTION(0);

    private static final Map<Integer, TransStatusEnum> returnMap = new HashMap<>();

    static {
        TransStatusEnum[] var0 = values();
        int var1 = var0.length;

        for (int var2 = 0; var2 < var1; ++var2) {
            TransStatusEnum returnCodeEnum = var0[var2];
            returnMap.put(returnCodeEnum.value, returnCodeEnum);
        }
    }

    private final int value;

    private TransStatusEnum(int value) {
        this.value = value;
    }

    public static TransStatusEnum fromInt(int iValue) {
        return (TransStatusEnum) returnMap.get(iValue);
    }

    public static Map<Integer, String> toHashMap() {
        Map<Integer, String> map = new HashMap<>();
        for (TransStatusEnum item : TransStatusEnum.values()) {
            map.put(item.value, TransStatusEnum.fromInt(item.value).name());
        }
        return map;
    }

    public int getValue() {
        return this.value;
    }
}
