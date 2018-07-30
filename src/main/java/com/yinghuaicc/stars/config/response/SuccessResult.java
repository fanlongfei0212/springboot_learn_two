package com.yinghuaicc.stars.config.response;

/**
 * @Author:Fly
 * @Date:Create in 2018/5/29 上午9:51
 * @Description: 成功结果
 * @Modified:
 */
public class SuccessResult extends JsonResult {

    private Object data;

    public Object getData() {
        return data;
    }

    public SuccessResult setData(Object data) {
        this.data = data;
        return this;
    }

    public SuccessResult(){}

    public SuccessResult(Object data){

        super.code = "0";
        this.data = data;
    }

}
