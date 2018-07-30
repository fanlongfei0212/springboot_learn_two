package com.yinghuaicc.stars.repository.model.standard;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 标准三角形业态适配值
 */
public class StandardConditionFitted {

    //id
    private  String id ;
    //版本id
    private String standardVerssionId;
    //版本名称
    private String standardVerssionName;
    //项目id
    private String projectId;
    //项目名称
    private String projectName;
    //业态id
    private String conditionId;
    //业态名称
    private String conditionName;
    //业种id
    private String majoId;
    //业种名称
    private String majoName;
    //适配值
    private BigDecimal fitted;

    private LocalDateTime createTime;
    private LocalDateTime modifyTime;
    private String createUser;
    private  String modifyUser;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStandardVerssionId() {
        return standardVerssionId;
    }

    public void setStandardVerssionId(String standardVerssionId) {
        this.standardVerssionId = standardVerssionId;
    }

    public String getStandardVerssionName() {
        return standardVerssionName;
    }

    public void setStandardVerssionName(String standardVerssionName) {
        this.standardVerssionName = standardVerssionName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getConditionId() {
        return conditionId;
    }

    public void setConditionId(String conditionId) {
        this.conditionId = conditionId;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public String getMajoId() {
        return majoId;
    }

    public void setMajoId(String majoId) {
        this.majoId = majoId;
    }

    public String getMajoName() {
        return majoName;
    }

    public void setMajoName(String majoName) {
        this.majoName = majoName;
    }

    public BigDecimal getFitted() {
        return fitted;
    }

    public void setFitted(BigDecimal fitted) {
        this.fitted = fitted;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
