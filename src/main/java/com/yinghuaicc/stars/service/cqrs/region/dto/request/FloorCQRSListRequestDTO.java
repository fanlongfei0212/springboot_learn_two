package com.yinghuaicc.stars.service.cqrs.region.dto.request;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/11 下午4:49
 * @Description: 层列表
 * @Modified:
 */
public class FloorCQRSListRequestDTO {

    //区域id
    private String areaId = "";

    //公司id
    private String companyId = "";

    //项目名称
    private String projectName = "";

    //方位
    private Integer location;

    public String getAreaId() {
        return areaId;
    }

    public FloorCQRSListRequestDTO setAreaId(String areaId) {
        this.areaId = areaId;
        return this;
    }

    public String getCompanyId() {
        return companyId;
    }

    public FloorCQRSListRequestDTO setCompanyId(String companyId) {
        this.companyId = companyId;
        return this;
    }

    public String getProjectName() {
        return projectName;
    }

    public FloorCQRSListRequestDTO setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public Integer getLocation() {
        return location;
    }

    public FloorCQRSListRequestDTO setLocation(Integer location) {
        this.location = location;
        return this;
    }
}
