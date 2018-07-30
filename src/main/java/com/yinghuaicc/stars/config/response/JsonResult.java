package com.yinghuaicc.stars.config.response;

/**
 * @Author:Fly
 * @Date:Create in 2018/5/29 上午9:48
 * @Description: Json返回结果
 * @Modified:
 */
public abstract class JsonResult {

    String code;

    public String getCode() {
        return code;
    }

    public JsonResult setCode(String code) {
        this.code = code;
        return this;
    }

    public static SuccessResult success(Object data){

        return new SuccessResult(data);
    }

    public static ErrorResult error(String code, String message){

        return new ErrorResult(code, message);
    }
}
