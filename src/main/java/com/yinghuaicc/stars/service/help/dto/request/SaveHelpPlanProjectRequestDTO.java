package com.yinghuaicc.stars.service.help.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/20 下午2:39
 * @Description: 添加项目帮扶计划
 * @Modified:
 */
public class SaveHelpPlanProjectRequestDTO {

    //项目id
    @NotEmpty(message = "HELP_PROJEC_SAVE_001")
    private String projectId;

    //类型 --》优秀:yx、良好:lh、提升:ts、合理:hl、亏损:ks
    @NotEmpty(message = "HELP_PROJEC_SAVE_002")
    private String type;

    //帮扶内容
    @NotNull(message = "HELP_PROJEC_SAVE_003")
    List<String> helpContext;

    public String getProjectId() {
        return projectId;
    }

    public SaveHelpPlanProjectRequestDTO setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getType() {
        return type;
    }

    public SaveHelpPlanProjectRequestDTO setType(String type) {
        this.type = type;
        return this;
    }

    public List<String> getHelpContext() {
        return helpContext;
    }

    public SaveHelpPlanProjectRequestDTO setHelpContext(List<String> helpContext) {
        this.helpContext = helpContext;
        return this;
    }
}
