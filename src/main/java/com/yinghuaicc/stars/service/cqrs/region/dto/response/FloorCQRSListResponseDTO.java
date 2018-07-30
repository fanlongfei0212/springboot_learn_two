package com.yinghuaicc.stars.service.cqrs.region.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/11 下午4:45
 * @Description: 层列表
 * @Modified:
 */
public class FloorCQRSListResponseDTO {

    //id
    private String id;

    //层名称
    private String name;

    //区域名称
    private String areaName;

    //项目名称
    private String projectName;

    //楼栋名称
    private String buildingName;

    //方位
    private Integer location;

    //状态（true：启用，false：禁用）
    private boolean state;

    //面积
    private BigDecimal acreage;

    //创建时间
    private LocalDateTime createTime;

    //修改时间
    private LocalDateTime modifyTime;

    public String getId() {
        return id;
    }

    public FloorCQRSListResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getProjectName() {
        return projectName;
    }

    public FloorCQRSListResponseDTO setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public FloorCQRSListResponseDTO setBuildingName(String buildingName) {
        this.buildingName = buildingName;
        return this;
    }

    public Integer getLocation() {
        return location;
    }

    public FloorCQRSListResponseDTO setLocation(Integer location) {
        this.location = location;
        return this;
    }

    public boolean isState() {
        return state;
    }

    public FloorCQRSListResponseDTO setState(boolean state) {
        this.state = state;
        return this;
    }

    public BigDecimal getAcreage() {
        return acreage;
    }

    public FloorCQRSListResponseDTO setAcreage(BigDecimal acreage) {
        this.acreage = acreage;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public FloorCQRSListResponseDTO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public FloorCQRSListResponseDTO setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getName() {
        return name;
    }

    public FloorCQRSListResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getAreaName() {
        return areaName;
    }

    public FloorCQRSListResponseDTO setAreaName(String areaName) {
        this.areaName = areaName;
        return this;
    }
}
