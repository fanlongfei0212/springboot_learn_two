package com.yinghuaicc.stars.service.cqrs.region.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/11 下午11:43
 * @Description: 铺位详情
 * @Modified:
 */
public class RoomCQRSInfoByIdResponseDTO {

    //铺位id
    private String id;

    //铺位名称
    private String name;

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

    //层id
    private String floorId;

    //层名称
    private String floorName;

    //是否启用（1：启用，2：禁用，3：签约中）
    private Integer state;

    //面积
    private BigDecimal acreage;

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

    public RoomCQRSInfoByIdResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RoomCQRSInfoByIdResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getAreaId() {
        return areaId;
    }

    public RoomCQRSInfoByIdResponseDTO setAreaId(String areaId) {
        this.areaId = areaId;
        return this;
    }

    public String getAreaName() {
        return areaName;
    }

    public RoomCQRSInfoByIdResponseDTO setAreaName(String areaName) {
        this.areaName = areaName;
        return this;
    }

    public String getCompanyId() {
        return companyId;
    }

    public RoomCQRSInfoByIdResponseDTO setCompanyId(String companyId) {
        this.companyId = companyId;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public RoomCQRSInfoByIdResponseDTO setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getProjectId() {
        return projectId;
    }

    public RoomCQRSInfoByIdResponseDTO setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getProjectName() {
        return projectName;
    }

    public RoomCQRSInfoByIdResponseDTO setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public RoomCQRSInfoByIdResponseDTO setBuildingId(String buildingId) {
        this.buildingId = buildingId;
        return this;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public RoomCQRSInfoByIdResponseDTO setBuildingName(String buildingName) {
        this.buildingName = buildingName;
        return this;
    }

    public String getFloorId() {
        return floorId;
    }

    public RoomCQRSInfoByIdResponseDTO setFloorId(String floorId) {
        this.floorId = floorId;
        return this;
    }

    public String getFloorName() {
        return floorName;
    }

    public RoomCQRSInfoByIdResponseDTO setFloorName(String floorName) {
        this.floorName = floorName;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public RoomCQRSInfoByIdResponseDTO setState(Integer state) {
        this.state = state;
        return this;
    }

    public BigDecimal getAcreage() {
        return acreage;
    }

    public RoomCQRSInfoByIdResponseDTO setAcreage(BigDecimal acreage) {
        this.acreage = acreage;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public RoomCQRSInfoByIdResponseDTO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public RoomCQRSInfoByIdResponseDTO setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public RoomCQRSInfoByIdResponseDTO setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public RoomCQRSInfoByIdResponseDTO setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public RoomCQRSInfoByIdResponseDTO setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
        return this;
    }

    public String getModifyUserName() {
        return modifyUserName;
    }

    public RoomCQRSInfoByIdResponseDTO setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName;
        return this;
    }
}
