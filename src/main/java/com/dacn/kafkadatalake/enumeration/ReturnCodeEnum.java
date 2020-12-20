package com.dacn.kafkadatalake.enumeration;

public enum ReturnCodeEnum {
    SUCCESSFUL(1, "Successfully"),
    SYSTEM_BUSY(0, "System busy! Please try again later"),
    INVALID_STATUS(-1, "Invalid status");

    private final int value;
    private final String message;

    private ReturnCodeEnum(int value, String msg) {
        this.value = value;
        this.message = msg;
    }

    public static String getMessage(int value) {
        ReturnCodeEnum rc = fromValue(value);
        return rc != null ? rc.getMessage() : "";
    }

    public static ReturnCodeEnum fromValue(int value) {
        ReturnCodeEnum[] var1 = values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            ReturnCodeEnum s = var1[var3];
            if (s.value == value) {
                return s;
            }
        }

        return null;
    }

    public int getValue() {
        return this.value;
    }

    public String getMessage() {
        return this.message;
    }
}
