package com.yinghuaicc.stars.service.cqrs.help.dto.response;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/20 上午10:47
 * @Description: 项目帮扶计划列表
 * @Modified:
 */
public class FindHelpPlanProjectListCQRSResponseDTO {

    //项目id
    private String projectId;

    //项目名称
    private String projectName;

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

    public FindHelpPlanProjectListCQRSResponseDTO setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getProjectName() {
        return projectName;
    }

    public FindHelpPlanProjectListCQRSResponseDTO setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public String getYx() {
        return yx;
    }

    public FindHelpPlanProjectListCQRSResponseDTO setYx(String yx) {
        this.yx = yx;
        return this;
    }

    public String getLh() {
        return lh;
    }

    public FindHelpPlanProjectListCQRSResponseDTO setLh(String lh) {
        this.lh = lh;
        return this;
    }

    public String getTs() {
        return ts;
    }

    public FindHelpPlanProjectListCQRSResponseDTO setTs(String ts) {
        this.ts = ts;
        return this;
    }

    public String getHl() {
        return hl;
    }

    public FindHelpPlanProjectListCQRSResponseDTO setHl(String hl) {
        this.hl = hl;
        return this;
    }

    public String getKs() {
        return ks;
    }

    public FindHelpPlanProjectListCQRSResponseDTO setKs(String ks) {
        this.ks = ks;
        return this;
    }
}
