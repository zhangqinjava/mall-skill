package com.mall.common.exception;

public enum EnumCode {
    SUCCESS(200,"success"),
    FAIL(501,"fail"),
    PARAM_ERROR(502,"param error");
    private final int code;
    private final String msg;
    EnumCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
    public EnumCode fromCode(int code) {
        for (EnumCode e : EnumCode.values()) {
            if (e.code == code) {
                return e;
            }
        }
        throw new IllegalArgumentException("未知状态码: " + code);
    }
}
