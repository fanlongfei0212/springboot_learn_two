package com.yinghuaicc.stars.service.cqrs.region.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/3 下午5:28
 * @Description: 项目管理列表
 * @Modified:
 */
public class ProjectCQRSListResponseDTO {

    //项目id
    private String projectId;

    //项目名称
    private String projectName;

    //区域名称
    private String areaName;

    //城市名称
    private String companyName;

    //项目负责人名称
    private String projectHeadName;

    //项目运营人名称
    private String projectAuditName;

    //创建时间
    private LocalDateTime createTime;

    //修改时间
    private LocalDateTime modifyTime;

    //状态，是否启用
    private boolean state;

    //面积
    private BigDecimal acreage;

    public String getProjectId() {
        return projectId;
    }

    public ProjectCQRSListResponseDTO setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getProjectName() {
        return projectName;
    }

    public ProjectCQRSListResponseDTO setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public String getAreaName() {
        return areaName;
    }

    public ProjectCQRSListResponseDTO setAreaName(String areaName) {
        this.areaName = areaName;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public ProjectCQRSListResponseDTO setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getProjectHeadName() {
        return projectHeadName;
    }

    public ProjectCQRSListResponseDTO setProjectHeadName(String projectHeadName) {
        this.projectHeadName = projectHeadName;
        return this;
    }

    public String getProjectAuditName() {
        return projectAuditName;
    }

    public ProjectCQRSListResponseDTO setProjectAuditName(String projectAuditName) {
        this.projectAuditName = projectAuditName;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public ProjectCQRSListResponseDTO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public ProjectCQRSListResponseDTO setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public boolean isState() {
        return state;
    }

    public ProjectCQRSListResponseDTO setState(boolean state) {
        this.state = state;
        return this;
    }

    public BigDecimal getAcreage() {
        return acreage;
    }

    public ProjectCQRSListResponseDTO setAcreage(BigDecimal acreage) {
        this.acreage = acreage;
        return this;
    }
}
