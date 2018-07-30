package com.yinghuaicc.stars.service.formula.dto.response;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/13 下午3:18
 * @Description: 公式详情
 * @Modified:
 */
public class FindFormulaByIdResponseDTO {

    //id
    private String id;

    //编号
    private String num;

    //结果，(指标id)
    private String targetId;

    //结果，(指标名称)
    private String targetName;

    //运算公式
    private String operationFormula;

    //结果公式
    private String resultFormula;

    //状态（true:启用，false：禁用）
    private boolean state;

    //创建时间
    private LocalDateTime createTime;

    //修改时间
    private LocalDateTime modifyTime;

    public String getId() {
        return id;
    }

    public FindFormulaByIdResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public FindFormulaByIdResponseDTO setNum(String num) {
        this.num = num;
        return this;
    }

    public String getTargetId() {
        return targetId;
    }

    public FindFormulaByIdResponseDTO setTargetId(String targetId) {
        this.targetId = targetId;
        return this;
    }

    public String getTargetName() {
        return targetName;
    }

    public FindFormulaByIdResponseDTO setTargetName(String targetName) {
        this.targetName = targetName;
        return this;
    }

    public String getOperationFormula() {
        return operationFormula;
    }

    public FindFormulaByIdResponseDTO setOperationFormula(String operationFormula) {
        this.operationFormula = operationFormula;
        return this;
    }

    public String getResultFormula() {
        return resultFormula;
    }

    public FindFormulaByIdResponseDTO setResultFormula(String resultFormula) {
        this.resultFormula = resultFormula;
        return this;
    }

    public boolean isState() {
        return state;
    }

    public FindFormulaByIdResponseDTO setState(boolean state) {
        this.state = state;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public FindFormulaByIdResponseDTO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public FindFormulaByIdResponseDTO setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }
}
