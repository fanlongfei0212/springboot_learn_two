package com.yinghuaicc.stars.service.region.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/12 上午1:03
 * @Description: 编辑铺位
 * @Modified:
 */
public class EditRoomRequestDTO {

    //id
    @NotEmpty(message = "REGION_EDIT_ROOM_009")
    private String id;

    //铺位名称
    @NotEmpty(message = "REGION_EDIT_ROOM_001")
    private String name;

    //区域id
    @NotEmpty(message = "REGION_EDIT_ROOM_002")
    private String areaId;

    //公司id
    @NotEmpty(message = "REGION_EDIT_ROOM_003")
    private String companyId;

    //项目id
    @NotEmpty(message = "REGION_EDIT_ROOM_004")
    private String projectId;

    //楼栋id
    @NotEmpty(message = "REGION_EDIT_ROOM_005")
    private String buildingId;

    //层id
    @NotEmpty(message = "REGION_EDIT_ROOM_006")
    private String floorId;

    //是否启用（1：启用，2：禁用，3：签约中）
    @NotNull(message = "REGION_EDIT_ROOM_007")
    private Integer state;

    //面积
    @NotNull(message = "REGION_EDIT_ROOM_008")
    private BigDecimal acreage;

    public String getId() {
        return id;
    }

    public EditRoomRequestDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public EditRoomRequestDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getAreaId() {
        return areaId;
    }

    public EditRoomRequestDTO setAreaId(String areaId) {
        this.areaId = areaId;
        return this;
    }

    public String getCompanyId() {
        return companyId;
    }

    public EditRoomRequestDTO setCompanyId(String companyId) {
        this.companyId = companyId;
        return this;
    }

    public String getProjectId() {
        return projectId;
    }

    public EditRoomRequestDTO setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public EditRoomRequestDTO setBuildingId(String buildingId) {
        this.buildingId = buildingId;
        return this;
    }

    public String getFloorId() {
        return floorId;
    }

    public EditRoomRequestDTO setFloorId(String floorId) {
        this.floorId = floorId;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public EditRoomRequestDTO setState(Integer state) {
        this.state = state;
        return this;
    }

    public BigDecimal getAcreage() {
        return acreage;
    }

    public EditRoomRequestDTO setAcreage(BigDecimal acreage) {
        this.acreage = acreage;
        return this;
    }
}
