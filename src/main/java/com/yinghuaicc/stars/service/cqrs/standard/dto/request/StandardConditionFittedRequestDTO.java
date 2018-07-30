package com.yinghuaicc.stars.service.cqrs.standard.dto.request;

public class StandardConditionFittedRequestDTO {
    private  String projectId;
    //业态id
    private  String conditionId;
    private String conditionName;
    //业种id
    private String majoId;
    private String majoName;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
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
}
