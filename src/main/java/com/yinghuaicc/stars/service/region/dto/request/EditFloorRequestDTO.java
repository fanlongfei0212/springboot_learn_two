package com.yinghuaicc.stars.service.region.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/11 下午3:11
 * @Description: 编辑层
 * @Modified:
 */
public class EditFloorRequestDTO {

    //层id
    @NotEmpty(message = "REGION_EDIT_FLOOR_001")
    private String id;

    //区域id
    @NotEmpty(message = "REGION_EDIT_FLOOR_002")
    private String areaId;

    //公司id
    @NotEmpty(message = "REGION_EDIT_FLOOR_003")
    private String companyId;

    //项目id
    @NotEmpty(message = "REGION_EDIT_FLOOR_004")
    private String projectId;

    //楼栋id
    @NotEmpty(message = "REGION_EDIT_FLOOR_005")
    private String buildingId;

    //层名称
    @NotEmpty(message = "REGION_EDIT_FLOOR_006")
    private String name;

    //（1：地上，2：地下）
    @NotNull(message = "REGION_EDIT_FLOOR_007")
    private Integer location;

    //面积
    @NotNull(message = "REGION_EDIT_FLOOR_008")
    private BigDecimal acreage;

    //状态（true：启用，false：禁用）
    @NotNull(message = "REGION_EDIT_FLOOR_009")
    private boolean state;

    public String getId() {
        return id;
    }

    public EditFloorRequestDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getAreaId() {
        return areaId;
    }

    public EditFloorRequestDTO setAreaId(String areaId) {
        this.areaId = areaId;
        return this;
    }

    public String getCompanyId() {
        return companyId;
    }

    public EditFloorRequestDTO setCompanyId(String companyId) {
        this.companyId = companyId;
        return this;
    }

    public String getProjectId() {
        return projectId;
    }

    public EditFloorRequestDTO setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public EditFloorRequestDTO setBuildingId(String buildingId) {
        this.buildingId = buildingId;
        return this;
    }

    public String getName() {
        return name;
    }

    public EditFloorRequestDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getLocation() {
        return location;
    }

    public EditFloorRequestDTO setLocation(Integer location) {
        this.location = location;
        return this;
    }

    public BigDecimal getAcreage() {
        return acreage;
    }

    public EditFloorRequestDTO setAcreage(BigDecimal acreage) {
        this.acreage = acreage;
        return this;
    }

    public boolean isState() {
        return state;
    }

    public EditFloorRequestDTO setState(boolean state) {
        this.state = state;
        return this;
    }
}
