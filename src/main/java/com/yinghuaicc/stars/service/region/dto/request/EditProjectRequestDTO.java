package com.yinghuaicc.stars.service.region.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/4 上午12:55
 * @Description: 编辑项目
 * @Modified:
 */
public class EditProjectRequestDTO {

    //项目id
    @NotEmpty(message = "REGION_EDIT_PROJECT_007")
    private String projectId;

    //区域id
    @NotEmpty(message = "REGION_EDIT_PROJECT_010")
    private String areaId;

    //项目名称
    @NotEmpty(message = "REGION_EDIT_PROJECT_001")
    private String projectName;

    //城市公司id（区域公司）
    @NotEmpty(message = "REGION_EDIT_PROJECT_002")
    private String companyId;

    //是否启用（true：启用，false：禁用）
    @NotNull(message = "REGION_EDIT_PROJECT_003")
    private boolean state;

    //项目负责人id
    @NotEmpty(message = "REGION_EDIT_PROJECT_004")
    private String projectHeadId;

//    //项目运营人id
//    @NotEmpty(message = "REGION_EDIT_PROJECT_005")
//    private String projectAuditId;

//    //项目负责组员id
//    @NotNull(message = "REGION_EDIT_PROJECT_006")
//    private List<String> employeeProjectTeamId = new ArrayList<String>();

    //面积
    @NotNull(message = "REGION_EDIT_PROJECT_009")
    private BigDecimal acreage;

    //项目图片
    private List<String> projectImages = new ArrayList<>();

    public String getProjectId() {
        return projectId;
    }

    public EditProjectRequestDTO setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getAreaId() {
        return areaId;
    }

    public EditProjectRequestDTO setAreaId(String areaId) {
        this.areaId = areaId;
        return this;
    }

    public String getCompanyId() {
        return companyId;
    }

    public EditProjectRequestDTO setCompanyId(String companyId) {
        this.companyId = companyId;
        return this;
    }

    public boolean isState() {
        return state;
    }

    public EditProjectRequestDTO setState(boolean state) {
        this.state = state;
        return this;
    }

    public String getProjectHeadId() {
        return projectHeadId;
    }

    public EditProjectRequestDTO setProjectHeadId(String projectHeadId) {
        this.projectHeadId = projectHeadId;
        return this;
    }

    public List<String> getProjectImages() {
        return projectImages;
    }

    public EditProjectRequestDTO setProjectImages(List<String> projectImages) {
        this.projectImages = projectImages;
        return this;
    }

    public BigDecimal getAcreage() {
        return acreage;
    }

    public EditProjectRequestDTO setAcreage(BigDecimal acreage) {
        this.acreage = acreage;
        return this;
    }

    public String getProjectName() {
        return projectName;
    }

    public EditProjectRequestDTO setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }
}
