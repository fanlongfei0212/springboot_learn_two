package com.yinghuaicc.stars.service.region.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/11 下午11:21
 * @Description: 添加铺位
 * @Modified:
 */
public class SaveRoomRequestDTO {

    //铺位名称
    @NotEmpty(message = "REGION_SAVE_ROOM_001")
    private String name;

    //区域id
    @NotEmpty(message = "REGION_SAVE_ROOM_002")
    private String areaId;

    //公司id
    @NotEmpty(message = "REGION_SAVE_ROOM_003")
    private String companyId;

    //项目id
    @NotEmpty(message = "REGION_SAVE_ROOM_004")
    private String projectId;

    //楼栋id
    @NotEmpty(message = "REGION_SAVE_ROOM_005")
    private String buildingId;

    //层id
    @NotEmpty(message = "REGION_SAVE_ROOM_006")
    private String floorId;

    //是否启用（1：启用，2：禁用，3：签约中）
    @NotNull(message = "REGION_SAVE_ROOM_007")
    private Integer state;

    //面积
    @NotNull(message = "REGION_SAVE_ROOM_008")
    private BigDecimal acreage;

    public String getName() {
        return name;
    }

    public SaveRoomRequestDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getAreaId() {
        return areaId;
    }

    public SaveRoomRequestDTO setAreaId(String areaId) {
        this.areaId = areaId;
        return this;
    }

    public String getCompanyId() {
        return companyId;
    }

    public SaveRoomRequestDTO setCompanyId(String companyId) {
        this.companyId = companyId;
        return this;
    }

    public String getProjectId() {
        return projectId;
    }

    public SaveRoomRequestDTO setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public SaveRoomRequestDTO setBuildingId(String buildingId) {
        this.buildingId = buildingId;
        return this;
    }

    public String getFloorId() {
        return floorId;
    }

    public SaveRoomRequestDTO setFloorId(String floorId) {
        this.floorId = floorId;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public SaveRoomRequestDTO setState(Integer state) {
        this.state = state;
        return this;
    }

    public BigDecimal getAcreage() {
        return acreage;
    }

    public SaveRoomRequestDTO setAcreage(BigDecimal acreage) {
        this.acreage = acreage;
        return this;
    }
}
