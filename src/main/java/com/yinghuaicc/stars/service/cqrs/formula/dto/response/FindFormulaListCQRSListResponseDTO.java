package com.yinghuaicc.stars.service.cqrs.formula.dto.response;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/13 下午3:21
 * @Description: 公式列表
 * @Modified:
 */
public class FindFormulaListCQRSListResponseDTO {

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

    //创建人
    private String createUser;

    //修改人
    private String modifyUser;

    //创建人名称
    private String createUserName;

    //修改人名称
    private String modifyUserName;

    public String getId() {
        return id;
    }

    public FindFormulaListCQRSListResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public FindFormulaListCQRSListResponseDTO setNum(String num) {
        this.num = num;
        return this;
    }

    public String getTargetId() {
        return targetId;
    }

    public FindFormulaListCQRSListResponseDTO setTargetId(String targetId) {
        this.targetId = targetId;
        return this;
    }

    public String getTargetName() {
        return targetName;
    }

    public FindFormulaListCQRSListResponseDTO setTargetName(String targetName) {
        this.targetName = targetName;
        return this;
    }

    public String getOperationFormula() {
        return operationFormula;
    }

    public FindFormulaListCQRSListResponseDTO setOperationFormula(String operationFormula) {
        this.operationFormula = operationFormula;
        return this;
    }

    public String getResultFormula() {
        return resultFormula;
    }

    public FindFormulaListCQRSListResponseDTO setResultFormula(String resultFormula) {
        this.resultFormula = resultFormula;
        return this;
    }

    public boolean isState() {
        return state;
    }

    public FindFormulaListCQRSListResponseDTO setState(boolean state) {
        this.state = state;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public FindFormulaListCQRSListResponseDTO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public FindFormulaListCQRSListResponseDTO setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public FindFormulaListCQRSListResponseDTO setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public FindFormulaListCQRSListResponseDTO setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public FindFormulaListCQRSListResponseDTO setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
        return this;
    }

    public String getModifyUserName() {
        return modifyUserName;
    }

    public FindFormulaListCQRSListResponseDTO setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName;
        return this;
    }
}
