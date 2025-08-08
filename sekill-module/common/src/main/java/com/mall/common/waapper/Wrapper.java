package com.mall.common.waapper;

import com.mall.common.exception.EnumCode;

public class Wrapper {
    public Wrapper() {
    }
    public static <T> Result<T> success(T msg){
        return new Result(EnumCode.SUCCESS.getCode(),EnumCode.SUCCESS.getMsg());
    }
    public static <T> Result<T> wrap(int code,T msg){
        return new Result(code,msg);
    }
    public static <T> Result<T> fail(T msg){
        return new Result(EnumCode.FAIL.getCode(),EnumCode.FAIL.getMsg());
    }
    public static <T> Result<T> error(int code, T msg){
        return new Result(code,msg);
    }
    public static <T> Result<T> fail(EnumCode code){
        return new Result(code.getCode(),code.getMsg());
    }

}
