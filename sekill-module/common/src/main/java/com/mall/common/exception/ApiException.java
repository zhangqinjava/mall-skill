package com.mall.common.exception;

public class ApiException extends Exception{
    private int code;
    private String msg;
    public ApiException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public ApiException( String msg, Throwable cause) {
        super(msg, cause);
    }

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public ApiException() {}

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }


}
