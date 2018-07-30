package com.yinghuaicc.stars.service.region.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/4 上午12:15
 * @Description: 添加项目
 * @Modified:
 */
public class SaveProjectRequestDTO {

    //项目名称
    @NotEmpty(message = "REGION_SAVE_PROJECT_001")
    private String name;

    //区域id
    @NotEmpty(message = "REGION_SAVE_PROJECT_008")
    private String areaId;

    //城市公司id（城市公司）
    @NotEmpty(message = "REGION_SAVE_PROJECT_002")
    private String companyId;

    //是否启用（true：启用，false：禁用）
    @NotNull(message = "REGION_SAVE_PROJECT_003")
    private boolean state;

    //项目负责人id
    @NotEmpty(message = "REGION_SAVE_PROJECT_004")
    private String projectHeadId;

    //面积
    @NotNull(message = "REGION_SAVE_PROJECT_007")
    private BigDecimal acreage;

    //项目图片
    private List<String> projectImages = new ArrayList<>();

    public String getName() {
        return name;
    }

    public SaveProjectRequestDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getAreaId() {
        return areaId;
    }

    public SaveProjectRequestDTO setAreaId(String areaId) {
        this.areaId = areaId;
        return this;
    }

    public String getCompanyId() {
        return companyId;
    }

    public SaveProjectRequestDTO setCompanyId(String companyId) {
        this.companyId = companyId;
        return this;
    }

    public boolean isState() {
        return state;
    }

    public SaveProjectRequestDTO setState(boolean state) {
        this.state = state;
        return this;
    }

    public String getProjectHeadId() {
        return projectHeadId;
    }

    public SaveProjectRequestDTO setProjectHeadId(String projectHeadId) {
        this.projectHeadId = projectHeadId;
        return this;
    }

    public List<String> getProjectImages() {
        return projectImages;
    }

    public SaveProjectRequestDTO setProjectImages(List<String> projectImages) {
        this.projectImages = projectImages;
        return this;
    }

    public BigDecimal getAcreage() {
        return acreage;
    }

    public SaveProjectRequestDTO setAcreage(BigDecimal acreage) {
        this.acreage = acreage;
        return this;
    }
}
