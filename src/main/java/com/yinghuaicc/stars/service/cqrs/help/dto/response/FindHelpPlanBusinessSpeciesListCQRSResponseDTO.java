package com.yinghuaicc.stars.service.cqrs.help.dto.response;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/21 下午1:01
 * @Description: 业种帮扶计划列表
 * @Modified:
 */
public class FindHelpPlanBusinessSpeciesListCQRSResponseDTO {

    //项目id
    private String projectId;

    //项目名称
    private String projectName;

    //业态id
    private String businessFormId;

    //业态名称
    private String businessFormName;

    //业种id
    private String businessSpeciesId;

    //业种名称
    private String businessSpeciesName;

    //优秀
    private String yx;

    //良好
    private String lh;

    //提升
    private String ts;

    //合理
    private String hl;

    //亏损
    private String ks;

    public String getProjectId() {
        return projectId;
    }

    public FindHelpPlanBusinessSpeciesListCQRSResponseDTO setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getProjectName() {
        return projectName;
    }

    public FindHelpPlanBusinessSpeciesListCQRSResponseDTO setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public String getBusinessFormId() {
        return businessFormId;
    }

    public FindHelpPlanBusinessSpeciesListCQRSResponseDTO setBusinessFormId(String businessFormId) {
        this.businessFormId = businessFormId;
        return this;
    }

    public String getBusinessFormName() {
        return businessFormName;
    }

    public FindHelpPlanBusinessSpeciesListCQRSResponseDTO setBusinessFormName(String businessFormName) {
        this.businessFormName = businessFormName;
        return this;
    }

    public String getBusinessSpeciesId() {
        return businessSpeciesId;
    }

    public FindHelpPlanBusinessSpeciesListCQRSResponseDTO setBusinessSpeciesId(String businessSpeciesId) {
        this.businessSpeciesId = businessSpeciesId;
        return this;
    }

    public String getBusinessSpeciesName() {
        return businessSpeciesName;
    }

    public FindHelpPlanBusinessSpeciesListCQRSResponseDTO setBusinessSpeciesName(String businessSpeciesName) {
        this.businessSpeciesName = businessSpeciesName;
        return this;
    }

    public String getYx() {
        return yx;
    }

    public FindHelpPlanBusinessSpeciesListCQRSResponseDTO setYx(String yx) {
        this.yx = yx;
        return this;
    }

    public String getLh() {
        return lh;
    }

    public FindHelpPlanBusinessSpeciesListCQRSResponseDTO setLh(String lh) {
        this.lh = lh;
        return this;
    }

    public String getTs() {
        return ts;
    }

    public FindHelpPlanBusinessSpeciesListCQRSResponseDTO setTs(String ts) {
        this.ts = ts;
        return this;
    }

    public String getHl() {
        return hl;
    }

    public FindHelpPlanBusinessSpeciesListCQRSResponseDTO setHl(String hl) {
        this.hl = hl;
        return this;
    }

    public String getKs() {
        return ks;
    }

    public FindHelpPlanBusinessSpeciesListCQRSResponseDTO setKs(String ks) {
        this.ks = ks;
        return this;
    }
}
