package com.yinghuaicc.stars.service.cqrs.contract.dto.request;

/**
 * xjp
 * 展示三角理论参数类
 */
public class ContractTriangleCQRSListRequestDTO {

    //区域id
    private String areaId = "";

    //项目id
    private String projectId = "";

    //层id
    private String floorId = "";

    //业态id
    private String businessFormId = "";

    //品牌id
    private String brandId = "";

    //铺位名称
    private String name = "";

    public String getAreaId() {
        return areaId;
    }

    public ContractTriangleCQRSListRequestDTO setAreaId(String areaId) {
        this.areaId = areaId;
        return this;
    }

    public String getProjectId() {
        return projectId;
    }

    public ContractTriangleCQRSListRequestDTO setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getFloorId() {
        return floorId;
    }

    public ContractTriangleCQRSListRequestDTO setFloorId(String floorId) {
        this.floorId = floorId;
        return this;
    }

    public String getBusinessFormId() {
        return businessFormId;
    }

    public ContractTriangleCQRSListRequestDTO setBusinessFormId(String businessFormId) {
        this.businessFormId = businessFormId;
        return this;
    }

    public String getBrandId() {
        return brandId;
    }

    public ContractTriangleCQRSListRequestDTO setBrandId(String brandId) {
        this.brandId = brandId;
        return this;
    }

    public String getName() {
        return name;
    }

    public ContractTriangleCQRSListRequestDTO setName(String name) {
        this.name = name;
        return this;
    }
}
