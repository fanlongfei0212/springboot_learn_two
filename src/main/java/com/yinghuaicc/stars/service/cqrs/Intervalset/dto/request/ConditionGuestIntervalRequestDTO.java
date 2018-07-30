package com.yinghuaicc.stars.service.cqrs.Intervalset.dto.request;

/**
 * 区间设置品牌客销度参数类
 */
public class ConditionGuestIntervalRequestDTO {

    private String guestVerssionId;
    private String projectId;
    private String  projectName;
    //业态id
    private String conditionId;
    //业态名称
    private String  conditionName;
    //业种id
    private String majoId;
    //业种名称
    private String  majoName;


    public String getGuestVerssionId() {
        return guestVerssionId;
    }

    public void setGuestVerssionId(String guestVerssionId) {
        this.guestVerssionId = guestVerssionId;
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
}
