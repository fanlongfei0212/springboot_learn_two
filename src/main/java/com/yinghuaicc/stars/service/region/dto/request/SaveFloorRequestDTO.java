package com.yinghuaicc.stars.service.region.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/11 下午2:57
 * @Description: 添加层
 * @Modified:
 */
public class SaveFloorRequestDTO {

    //区域id
    @NotEmpty(message = "REGION_SAVE_FLOOR_001")
    private String areaId;

    //公司id
    @NotEmpty(message = "REGION_SAVE_FLOOR_002")
    private String companyId;

    //项目id
    @NotEmpty(message = "REGION_SAVE_FLOOR_003")
    private String projectId;

    //楼栋id
    @NotEmpty(message = "REGION_SAVE_FLOOR_004")
    private String buildingId;

    //层名称
    @NotEmpty(message = "REGION_SAVE_FLOOR_005")
    private String name;

    //（1：地上，2：地下）
    @NotNull(message = "REGION_SAVE_FLOOR_006")
    private Integer location;

    //面积
    @NotNull(message = "REGION_SAVE_FLOOR_007")
    private BigDecimal acreage;

    //状态（true：启用，false：禁用）
    @NotNull(message = "REGION_SAVE_FLOOR_008")
    private boolean state;

    public String getAreaId() {
        return areaId;
    }

    public SaveFloorRequestDTO setAreaId(String areaId) {
        this.areaId = areaId;
        return this;
    }

    public String getCompanyId() {
        return companyId;
    }

    public SaveFloorRequestDTO setCompanyId(String companyId) {
        this.companyId = companyId;
        return this;
    }

    public String getProjectId() {
        return projectId;
    }

    public SaveFloorRequestDTO setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public SaveFloorRequestDTO setBuildingId(String buildingId) {
        this.buildingId = buildingId;
        return this;
    }

    public String getName() {
        return name;
    }

    public SaveFloorRequestDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getLocation() {
        return location;
    }

    public SaveFloorRequestDTO setLocation(Integer location) {
        this.location = location;
        return this;
    }

    public BigDecimal getAcreage() {
        return acreage;
    }

    public SaveFloorRequestDTO setAcreage(BigDecimal acreage) {
        this.acreage = acreage;
        return this;
    }

    public boolean isState() {
        return state;
    }

    public SaveFloorRequestDTO setState(boolean state) {
        this.state = state;
        return this;
    }
}
