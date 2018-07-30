package com.yinghuaicc.stars.service.cqrs.triangle.dto.request;

/**
 * 三角理论展示参数DTO
 */
public class BrandTriangleRequestDTO {
    //品牌id
    private String brandId;
    //项目id
    private String  projectId;
    //项目名称
    private String projectName;
    //楼层id
    private String floorId;
    //楼层名称
    private String floorName;
    //业态id
    private String conditionId;
    //业态名称
    private String conditionName;
    //业种id
    private String majoId;
    //业种名称
    private String majoName;

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
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

    public String getConditionId() {
        return conditionId;
    }

    public void setConditionId(String conditionId) {
        this.conditionId = conditionId;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public String getMajoId() {
        return majoId;
    }

    public void setMajoId(String majoId) {
        this.majoId = majoId;
    }

    public String getMajoName() {
        return majoName;
    }

    public void setMajoName(String majoName) {
        this.majoName = majoName;
    }
}
