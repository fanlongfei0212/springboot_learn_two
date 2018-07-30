package com.yinghuaicc.stars.service.cqrs.help.dto.request;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/20 上午10:54
 * @Description: 项目帮扶计划查询
 * @Modified:
 */
public class FindHelpPlanProjectListCQRSRequestDTO {

    //区域id
    private String areaId;

    //项目id
    private String projectId;

    public String getAreaId() {
        return areaId;
    }

    public FindHelpPlanProjectListCQRSRequestDTO setAreaId(String areaId) {
        this.areaId = areaId;
        return this;
    }

    public String getProjectId() {
        return projectId;
    }

    public FindHelpPlanProjectListCQRSRequestDTO setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }
}
