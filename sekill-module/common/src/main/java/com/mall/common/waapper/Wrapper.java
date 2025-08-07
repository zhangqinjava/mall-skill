package com.mall.common.waapper;

public class Wrapper {
    public Wrapper() {
    }
    public static <T> Result<T> success(T msg){
        return new Result(200,msg);
    }
    public static <T> Result<T> wrap(int code,T msg){
        return new Result(code,msg);
    }
    public static <T> Result<T> fail(T msg){
        return new Result(500,msg);
    }
    public static <T> Result<T> error(int code, T msg){
        return new Result(code,msg);
    }

}
