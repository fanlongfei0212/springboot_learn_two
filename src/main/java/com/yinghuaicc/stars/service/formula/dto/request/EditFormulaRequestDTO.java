package com.yinghuaicc.stars.service.formula.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/13 下午2:51
 * @Description: 编辑公式
 * @Modified:
 */
public class EditFormulaRequestDTO {

    //id
    @NotEmpty(message = "FORMULA_EDIT_FORMULA_001")
    private String id;

    //结果，(指标id)
    @NotEmpty(message = "FORMULA_EDIT_FORMULA_002")
    private String targetId;

    //结果，(指标名称)
    @NotEmpty(message = "FORMULA_EDIT_FORMULA_003")
    private String targetName;

    //运算公式
    @NotEmpty(message = "FORMULA_EDIT_FORMULA_004")
    private String operationFormula;

    //结果公式
    @NotEmpty(message = "FORMULA_EDIT_FORMULA_005")
    private String resultFormula;

    //状态（true:启用，false：禁用）
    @NotNull(message = "FORMULA_EDIT_FORMULA_006")
    private boolean state;

    public String getId() {
        return id;
    }

    public EditFormulaRequestDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getTargetId() {
        return targetId;
    }

    public EditFormulaRequestDTO setTargetId(String targetId) {
        this.targetId = targetId;
        return this;
    }

    public String getTargetName() {
        return targetName;
    }

    public EditFormulaRequestDTO setTargetName(String targetName) {
        this.targetName = targetName;
        return this;
    }

    public String getOperationFormula() {
        return operationFormula;
    }

    public EditFormulaRequestDTO setOperationFormula(String operationFormula) {
        this.operationFormula = operationFormula;
        return this;
    }

    public String getResultFormula() {
        return resultFormula;
    }

    public EditFormulaRequestDTO setResultFormula(String resultFormula) {
        this.resultFormula = resultFormula;
        return this;
    }

    public boolean isState() {
        return state;
    }

    public EditFormulaRequestDTO setState(boolean state) {
        this.state = state;
        return this;
    }
}
