package com.yinghuaicc.stars.config.response;

/**
 * @Author:Fly
 * @Date:Create in 2018/5/29 上午9:51
 * @Description: 错误结果
 * @Modified:
 */
public class ErrorResult extends JsonResult {

    private String message;

    public String getMessage() {
        return message;
    }

    public ErrorResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public ErrorResult(){}

    public ErrorResult(String code, String message){

        super.code = code;
        this.message = message;
    }

}
