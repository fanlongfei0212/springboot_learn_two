package com.yinghuaicc.stars.service.cqrs.contract.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/16 下午7:13
 * @Description: 签约列表
 * @Modified:
 */
public class ContractCQRSListResponseDTO {

    //id
    private String id;

    //区域名称
    private String areaName;

    //项目名称
    private String projectName;

    //品牌名称
    private String brandName;

    //品牌id
    private String brandId;

    //楼层名称
    private String floorName;

    //铺位名称
    private String roomName;

    //业态名称
    private String businessFormName;

    //业种名称
    private String businessSpeciesName;

    //面积
    private BigDecimal acreage;

    //状态(true:已签约，false：签约已解除)
    private boolean state;

    //创建时间
    private LocalDateTime createTime;

    //修改时间
    private LocalDateTime modifyTime;

    public String getId() {
        return id;
    }

    public ContractCQRSListResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getAreaName() {
        return areaName;
    }

    public ContractCQRSListResponseDTO setAreaName(String areaName) {
        this.areaName = areaName;
        return this;
    }

    public String getProjectName() {
        return projectName;
    }

    public ContractCQRSListResponseDTO setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public String getBrandName() {
        return brandName;
    }

    public ContractCQRSListResponseDTO setBrandName(String brandName) {
        this.brandName = brandName;
        return this;
    }

    public String getFloorName() {
        return floorName;
    }

    public ContractCQRSListResponseDTO setFloorName(String floorName) {
        this.floorName = floorName;
        return this;
    }

    public String getRoomName() {
        return roomName;
    }

    public ContractCQRSListResponseDTO setRoomName(String roomName) {
        this.roomName = roomName;
        return this;
    }

    public String getBusinessFormName() {
        return businessFormName;
    }

    public ContractCQRSListResponseDTO setBusinessFormName(String businessFormName) {
        this.businessFormName = businessFormName;
        return this;
    }

    public String getBusinessSpeciesName() {
        return businessSpeciesName;
    }

    public ContractCQRSListResponseDTO setBusinessSpeciesName(String businessSpeciesName) {
        this.businessSpeciesName = businessSpeciesName;
        return this;
    }

    public BigDecimal getAcreage() {
        return acreage;
    }

    public ContractCQRSListResponseDTO setAcreage(BigDecimal acreage) {
        this.acreage = acreage;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public ContractCQRSListResponseDTO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public ContractCQRSListResponseDTO setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getBrandId() {
        return brandId;
    }

    public ContractCQRSListResponseDTO setBrandId(String brandId) {
        this.brandId = brandId;
        return this;
    }

    public boolean isState() {
        return state;
    }

    public ContractCQRSListResponseDTO setState(boolean state) {
        this.state = state;
        return this;
    }
}
