package com.yinghuaicc.stars.config.exception;

/**
 * @Author:Fly
 * @Date:Create in 2018/5/31 下午4:16
 * @Description: 自定义异常
 * @Modified:
 */
public class CustomException extends RuntimeException{

    public CustomException(){

        super();
    }

    public CustomException(String errorCode, String errorMessage){

        super(errorCode+":"+errorMessage);

        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    private String errorCode;

    private String errorMessage;

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
