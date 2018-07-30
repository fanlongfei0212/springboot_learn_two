package com.yinghuaicc.stars.service.cqrs.region.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/11 下午3:23
 * @Description: 层详情
 * @Modified:
 */
public class FloorCQRSInfoByIdResponseDTO {

    //层id
    private String id;

    //区域id
    private String areaId;

    //区域名称
    private String areaName;

    //公司id
    private String companyId;

    //公司名称
    private String companyName;

    //项目id
    private String projectId;

    //项目名称
    private String projectName;

    //楼栋id
    private String buildingId;

    //楼栋名称
    private String buildingName;

    //层名称
    private String name;

    //（1：地上，2：地下）
    private Integer location;

    //面积
    private BigDecimal acreage;

    //状态（true：启用，false：禁用）
    private boolean state;

    //创建时间
    private LocalDateTime createTime;

    //修改时间
    private LocalDateTime modifyTime;

    //创建人
    private String createUser;

    //修改人
    private String modifyUser;

    //创建人名称
    private String createUserName;

    //修改人名称
    private String modifyUserName;

    public String getId() {
        return id;
    }

    public FloorCQRSInfoByIdResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getAreaId() {
        return areaId;
    }

    public FloorCQRSInfoByIdResponseDTO setAreaId(String areaId) {
        this.areaId = areaId;
        return this;
    }

    public String getAreaName() {
        return areaName;
    }

    public FloorCQRSInfoByIdResponseDTO setAreaName(String areaName) {
        this.areaName = areaName;
        return this;
    }

    public String getCompanyId() {
        return companyId;
    }

    public FloorCQRSInfoByIdResponseDTO setCompanyId(String companyId) {
        this.companyId = companyId;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public FloorCQRSInfoByIdResponseDTO setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getProjectId() {
        return projectId;
    }

    public FloorCQRSInfoByIdResponseDTO setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getProjectName() {
        return projectName;
    }

    public FloorCQRSInfoByIdResponseDTO setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public FloorCQRSInfoByIdResponseDTO setBuildingId(String buildingId) {
        this.buildingId = buildingId;
        return this;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public FloorCQRSInfoByIdResponseDTO setBuildingName(String buildingName) {
        this.buildingName = buildingName;
        return this;
    }

    public String getName() {
        return name;
    }

    public FloorCQRSInfoByIdResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getLocation() {
        return location;
    }

    public FloorCQRSInfoByIdResponseDTO setLocation(Integer location) {
        this.location = location;
        return this;
    }

    public BigDecimal getAcreage() {
        return acreage;
    }

    public FloorCQRSInfoByIdResponseDTO setAcreage(BigDecimal acreage) {
        this.acreage = acreage;
        return this;
    }

    public boolean isState() {
        return state;
    }

    public FloorCQRSInfoByIdResponseDTO setState(boolean state) {
        this.state = state;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public FloorCQRSInfoByIdResponseDTO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public FloorCQRSInfoByIdResponseDTO setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public FloorCQRSInfoByIdResponseDTO setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public FloorCQRSInfoByIdResponseDTO setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public FloorCQRSInfoByIdResponseDTO setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
        return this;
    }

    public String getModifyUserName() {
        return modifyUserName;
    }

    public FloorCQRSInfoByIdResponseDTO setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName;
        return this;
    }
}
