package com.yinghuaicc.stars.service.cqrs.contract.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * xjp
 * 用户展示签约三角形
 */
public class ContractTriangleCQRSListResponseDTO {

    //id
    private String id;
    //区域名称
    private String areaName;
    //项目id
    private String projectId;
    //项目名称
    private String projectName;

    //品牌名称
    private String brandName;

    //品牌id
    private String brandId;
    //楼层id
    private String floorId;
    //楼层名称
    private String floorName;
    //铺位id
    private String roomId;
    //铺位名称
    private String roomName;
    //业态id
    private String businessFormId;
    //业态名称
    private String businessFormName;
    //业种id
    private String businessSpeciesId;
    //业种名称
    private String businessSpeciesName;
    //面积
    private BigDecimal acreage;
    //创建时间
    private LocalDateTime createTime;
    //修改时间
    private LocalDateTime modifyTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
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

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getBusinessFormId() {
        return businessFormId;
    }

    public void setBusinessFormId(String businessFormId) {
        this.businessFormId = businessFormId;
    }

    public String getBusinessFormName() {
        return businessFormName;
    }

    public void setBusinessFormName(String businessFormName) {
        this.businessFormName = businessFormName;
    }

    public String getBusinessSpeciesId() {
        return businessSpeciesId;
    }

    public void setBusinessSpeciesId(String businessSpeciesId) {
        this.businessSpeciesId = businessSpeciesId;
    }

    public String getBusinessSpeciesName() {
        return businessSpeciesName;
    }

    public void setBusinessSpeciesName(String businessSpeciesName) {
        this.businessSpeciesName = businessSpeciesName;
    }

    public BigDecimal getAcreage() {
        return acreage;
    }

    public void setAcreage(BigDecimal acreage) {
        this.acreage = acreage;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }
}
