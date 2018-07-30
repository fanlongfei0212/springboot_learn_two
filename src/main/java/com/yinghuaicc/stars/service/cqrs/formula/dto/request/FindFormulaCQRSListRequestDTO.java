package com.yinghuaicc.stars.service.cqrs.formula.dto.request;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/13 下午2:36
 * @Description: 公式查询
 * @Modified:
 */
public class FindFormulaCQRSListRequestDTO {

    //结果名称
    private String targetName = "";

    //指标分类(1:溢租率、2:客销度、3:适配值)
    private Integer targetType;

    //状态（true:启用，false：禁用）
    private boolean state;

    public String getTargetName() {
        return targetName;
    }

    public FindFormulaCQRSListRequestDTO setTargetName(String targetName) {
        this.targetName = targetName;
        return this;
    }

    public Integer getTargetType() {
        return targetType;
    }

    public FindFormulaCQRSListRequestDTO setTargetType(Integer targetType) {
        this.targetType = targetType;
        return this;
    }

    public boolean isState() {
        return state;
    }

    public FindFormulaCQRSListRequestDTO setState(boolean state) {
        this.state = state;
        return this;
    }
}
