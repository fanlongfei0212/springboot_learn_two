package com.yinghuaicc.stars.service.cqrs.region.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/12 上午12:12
 * @Description: 铺位列表
 * @Modified:
 */
public class RoomCQRSListResponseDTO {

    //铺位id
    private String id;

    //铺位编号
    private String num;

    //铺位名称
    private String name;

    //区域名称
    private String areaName;

    //公司名称
    private String companyName;

    //项目名称
    private String projectName;

    //楼栋名称
    private String buildingName;

    //楼层名称
    private String floorName;

    //是否启用（1：启用，2：禁用，3：签约中）
    private Integer state;

    //面积
    private BigDecimal acreage;

    //创建时间
    private LocalDateTime createTime;

    //修改时间
    private LocalDateTime modifyTime;

    public String getId() {
        return id;
    }

    public RoomCQRSListResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public RoomCQRSListResponseDTO setNum(String num) {
        this.num = num;
        return this;
    }

    public String getAreaName() {
        return areaName;
    }

    public RoomCQRSListResponseDTO setAreaName(String areaName) {
        this.areaName = areaName;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public RoomCQRSListResponseDTO setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getProjectName() {
        return projectName;
    }

    public RoomCQRSListResponseDTO setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public RoomCQRSListResponseDTO setBuildingName(String buildingName) {
        this.buildingName = buildingName;
        return this;
    }

    public String getFloorName() {
        return floorName;
    }

    public RoomCQRSListResponseDTO setFloorName(String floorName) {
        this.floorName = floorName;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public RoomCQRSListResponseDTO setState(Integer state) {
        this.state = state;
        return this;
    }

    public BigDecimal getAcreage() {
        return acreage;
    }

    public RoomCQRSListResponseDTO setAcreage(BigDecimal acreage) {
        this.acreage = acreage;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public RoomCQRSListResponseDTO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public RoomCQRSListResponseDTO setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getName() {
        return name;
    }

    public RoomCQRSListResponseDTO setName(String name) {
        this.name = name;
        return this;
    }
}
