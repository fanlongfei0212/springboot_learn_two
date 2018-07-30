package com.yinghuaicc.stars.service.help.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/21 下午12:50
 * @Description: 业种帮扶计划
 * @Modified:
 */
public class SaveHelpPlanBusinessSpeciesRequestDTO {

    //项目id
    @NotEmpty(message = "HELP_BUSINESS_SPECIES_SAVE_001")
    private String projectId;

    //业态id
    @NotEmpty(message = "HELP_BUSINESS_SPECIES_SAVE_002")
    private String businessFormId;

    //业种id
    @NotEmpty(message = "HELP_BUSINESS_SPECIES_SAVE_002")
    private String businessSpeciesId;

    //类型 --》优秀:yx、良好:lh、提升:ts、合理:hl、亏损:ks
    @NotEmpty(message = "HELP_BUSINESS_SPECIES_SAVE_004")
    private String type;

    //帮扶内容
    @NotNull(message = "HELP_BUSINESS_SPECIES_SAVE_005")
    List<String> helpContext;

    public String getProjectId() {
        return projectId;
    }

    public SaveHelpPlanBusinessSpeciesRequestDTO setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getBusinessFormId() {
        return businessFormId;
    }

    public SaveHelpPlanBusinessSpeciesRequestDTO setBusinessFormId(String businessFormId) {
        this.businessFormId = businessFormId;
        return this;
    }

    public String getBusinessSpeciesId() {
        return businessSpeciesId;
    }

    public SaveHelpPlanBusinessSpeciesRequestDTO setBusinessSpeciesId(String businessSpeciesId) {
        this.businessSpeciesId = businessSpeciesId;
        return this;
    }

    public String getType() {
        return type;
    }

    public SaveHelpPlanBusinessSpeciesRequestDTO setType(String type) {
        this.type = type;
        return this;
    }

    public List<String> getHelpContext() {
        return helpContext;
    }

    public SaveHelpPlanBusinessSpeciesRequestDTO setHelpContext(List<String> helpContext) {
        this.helpContext = helpContext;
        return this;
    }
}
