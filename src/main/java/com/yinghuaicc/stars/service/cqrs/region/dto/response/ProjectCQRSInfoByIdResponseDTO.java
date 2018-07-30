package com.yinghuaicc.stars.service.cqrs.region.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/4 下午2:00
 * @Description: 项目详情
 * @Modified:
 */
public class ProjectCQRSInfoByIdResponseDTO {

    //项目id
    private String projectId;

    //项目名称
    private String projectName;

    //区域id
    private String areaId;

    //区域名称
    private String areaName;

    //公司id（城市公司）
    private String companyId;

    //公司名称
    private String companyName;

    //状态
    private boolean state;

    //创建时间
    private LocalDateTime createTime;

    //修改时间
    private LocalDateTime modifyTime;

    //修改人名称
    private String modifyUserName;

    //项目负责人名称
    private String projectHeadName;

    //项目负责人id
    private String projectHeadId;

    //部门名称
    private String deptName;

    //部门id
    private String deptId;

    //项目负责组员名称
    private List<ProjectCQRSInfoEmployeeResponseDTO> projectRelationTeamName = new ArrayList<ProjectCQRSInfoEmployeeResponseDTO>();

    //项目图片
    private List<String> projectImages = new ArrayList<String>();

    //面积
    private BigDecimal acreage;

    public String getProjectId() {
        return projectId;
    }

    public ProjectCQRSInfoByIdResponseDTO setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getProjectName() {
        return projectName;
    }

    public ProjectCQRSInfoByIdResponseDTO setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public String getAreaId() {
        return areaId;
    }

    public ProjectCQRSInfoByIdResponseDTO setAreaId(String areaId) {
        this.areaId = areaId;
        return this;
    }

    public String getAreaName() {
        return areaName;
    }

    public ProjectCQRSInfoByIdResponseDTO setAreaName(String areaName) {
        this.areaName = areaName;
        return this;
    }

    public String getCompanyId() {
        return companyId;
    }

    public ProjectCQRSInfoByIdResponseDTO setCompanyId(String companyId) {
        this.companyId = companyId;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public ProjectCQRSInfoByIdResponseDTO setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public boolean isState() {
        return state;
    }

    public ProjectCQRSInfoByIdResponseDTO setState(boolean state) {
        this.state = state;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public ProjectCQRSInfoByIdResponseDTO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public ProjectCQRSInfoByIdResponseDTO setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getModifyUserName() {
        return modifyUserName;
    }

    public ProjectCQRSInfoByIdResponseDTO setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName;
        return this;
    }

    public String getProjectHeadName() {
        return projectHeadName;
    }

    public ProjectCQRSInfoByIdResponseDTO setProjectHeadName(String projectHeadName) {
        this.projectHeadName = projectHeadName;
        return this;
    }

    public List<ProjectCQRSInfoEmployeeResponseDTO> getProjectRelationTeamName() {
        return projectRelationTeamName;
    }

    public ProjectCQRSInfoByIdResponseDTO setProjectRelationTeamName(List<ProjectCQRSInfoEmployeeResponseDTO> projectRelationTeamName) {
        this.projectRelationTeamName = projectRelationTeamName;
        return this;
    }

    public List<String> getProjectImages() {
        return projectImages;
    }

    public ProjectCQRSInfoByIdResponseDTO setProjectImages(List<String> projectImages) {
        this.projectImages = projectImages;
        return this;
    }

    public BigDecimal getAcreage() {
        return acreage;
    }

    public ProjectCQRSInfoByIdResponseDTO setAcreage(BigDecimal acreage) {
        this.acreage = acreage;
        return this;
    }

    public String getProjectHeadId() {
        return projectHeadId;
    }

    public ProjectCQRSInfoByIdResponseDTO setProjectHeadId(String projectHeadId) {
        this.projectHeadId = projectHeadId;
        return this;
    }

    public String getDeptName() {
        return deptName;
    }

    public ProjectCQRSInfoByIdResponseDTO setDeptName(String deptName) {
        this.deptName = deptName;
        return this;
    }

    public String getDeptId() {
        return deptId;
    }

    public ProjectCQRSInfoByIdResponseDTO setDeptId(String deptId) {
        this.deptId = deptId;
        return this;
    }
}
