package com.yzy.utils;

/**
 * Description:
 * Date: 2018-10-18
 *
 * @author youzhiyong
 */
//@Data
public class Result<T> {

    public static final String DEFAULT_RESULT_MSG = "SUCCESS";

    public static final int DEFAULT_OK_CODE = 200;

    public static final int DEFAULT_ERROR_CODE = 400;

    private int code;

    private String msg;

    private  T data;

    public Result() {
        code = DEFAULT_OK_CODE;
        msg = DEFAULT_RESULT_MSG;
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result ok() {
        return new Result<>(DEFAULT_OK_CODE, DEFAULT_RESULT_MSG);
    }

    public static <T> Result ok(T data) {
        return new Result<>(DEFAULT_OK_CODE, DEFAULT_RESULT_MSG, data);
    }

    public static Result ok(String msg) {
        return new Result(DEFAULT_OK_CODE, msg);
    }

    public static <T> Result ok(String msg, T data) {
        return new Result<>(DEFAULT_OK_CODE, msg, data);
    }

    public static <T> Result ok(int code, String msg, T data) {
        return new Result<>(code, msg, data);
    }

    public static Result error(int code, String msg) {
        return new Result(code, msg);
    }

    public static Result error(String msg) {
        return new Result(DEFAULT_ERROR_CODE, msg);
    }

    /*@Override
    public String toString() {
        T t = this.getData();
        if (t instanceof List || t instanceof Collection) {
            return JSONObject.toJSONString(this, SerializerFeature.WriteNullListAsEmpty);
        } else {
            return JSONObject.toJSONString(this, SerializerFeature.WriteMapNullValue);
        }
    }*/

}
