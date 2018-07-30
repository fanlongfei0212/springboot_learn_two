package com.yinghuaicc.stars.repository.model.formula;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/13 下午1:44
 * @Description: 公式管理
 * @Modified:
 */
public class Formula {

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

    public String getId() {
        return id;
    }

    public Formula setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public Formula setNum(String num) {
        this.num = num;
        return this;
    }

    public String getTargetId() {
        return targetId;
    }

    public Formula setTargetId(String targetId) {
        this.targetId = targetId;
        return this;
    }

    public String getTargetName() {
        return targetName;
    }

    public Formula setTargetName(String targetName) {
        this.targetName = targetName;
        return this;
    }

    public String getOperationFormula() {
        return operationFormula;
    }

    public Formula setOperationFormula(String operationFormula) {
        this.operationFormula = operationFormula;
        return this;
    }

    public String getResultFormula() {
        return resultFormula;
    }

    public Formula setResultFormula(String resultFormula) {
        this.resultFormula = resultFormula;
        return this;
    }

    public boolean isState() {
        return state;
    }

    public Formula setState(boolean state) {
        this.state = state;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Formula setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public Formula setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public Formula setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public Formula setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
