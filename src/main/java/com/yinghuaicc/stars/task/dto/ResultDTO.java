package com.yinghuaicc.stars.task.dto;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/15 下午6:29
 * @Description: 外部系统Json结果数据结构
 * @Modified:
 */
public class ResultDTO <T>{

    private String msg;

    private String code;

    private boolean success;

    private List<T> result;

    public String getMsg() {
        return msg;
    }

    public ResultDTO<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public String getCode() {
        return code;
    }

    public ResultDTO<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public ResultDTO<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public List<T> getResult() {
        return result;
    }

    public ResultDTO<T> setResult(List<T> result) {
        this.result = result;
        return this;
    }
}
