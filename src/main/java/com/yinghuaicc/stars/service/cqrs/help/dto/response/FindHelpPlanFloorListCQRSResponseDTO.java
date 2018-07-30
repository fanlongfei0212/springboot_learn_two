package com.yinghuaicc.stars.service.cqrs.help.dto.response;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/20 下午8:01
 * @Description: 层帮扶计划
 * @Modified:
 */
public class FindHelpPlanFloorListCQRSResponseDTO {

    //项目id
    private String projectId;

    //项目名称
    private String projectName;

    //层id
    private String floorId;

    //层名称
    private String floorName;

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

    public FindHelpPlanFloorListCQRSResponseDTO setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getProjectName() {
        return projectName;
    }

    public FindHelpPlanFloorListCQRSResponseDTO setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public String getFloorId() {
        return floorId;
    }

    public FindHelpPlanFloorListCQRSResponseDTO setFloorId(String floorId) {
        this.floorId = floorId;
        return this;
    }

    public String getFloorName() {
        return floorName;
    }

    public FindHelpPlanFloorListCQRSResponseDTO setFloorName(String floorName) {
        this.floorName = floorName;
        return this;
    }

    public String getYx() {
        return yx;
    }

    public FindHelpPlanFloorListCQRSResponseDTO setYx(String yx) {
        this.yx = yx;
        return this;
    }

    public String getLh() {
        return lh;
    }

    public FindHelpPlanFloorListCQRSResponseDTO setLh(String lh) {
        this.lh = lh;
        return this;
    }

    public String getTs() {
        return ts;
    }

    public FindHelpPlanFloorListCQRSResponseDTO setTs(String ts) {
        this.ts = ts;
        return this;
    }

    public String getHl() {
        return hl;
    }

    public FindHelpPlanFloorListCQRSResponseDTO setHl(String hl) {
        this.hl = hl;
        return this;
    }

    public String getKs() {
        return ks;
    }

    public FindHelpPlanFloorListCQRSResponseDTO setKs(String ks) {
        this.ks = ks;
        return this;
    }
}
