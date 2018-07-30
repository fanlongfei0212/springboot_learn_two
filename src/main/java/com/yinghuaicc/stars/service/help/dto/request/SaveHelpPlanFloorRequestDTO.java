package com.yinghuaicc.stars.service.help.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/20 下午8:15
 * @Description: 层帮扶计划
 * @Modified:
 */
public class SaveHelpPlanFloorRequestDTO {

    //项目id
    @NotEmpty(message = "HELP_FLOOR_SAVE_001")
    private String projectId;

    //层id
    @NotEmpty(message = "HELP_FLOOR_SAVE_002")
    private String floorId;

    //类型 --》优秀:yx、良好:lh、提升:ts、合理:hl、亏损:ks
    @NotEmpty(message = "HELP_FLOOR_SAVE_003")
    private String type;

    //帮扶内容
    @NotNull(message = "HELP_FLOOR_SAVE_004")
    List<String> helpContext;

    public String getProjectId() {
        return projectId;
    }

    public SaveHelpPlanFloorRequestDTO setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getFloorId() {
        return floorId;
    }

    public SaveHelpPlanFloorRequestDTO setFloorId(String floorId) {
        this.floorId = floorId;
        return this;
    }

    public String getType() {
        return type;
    }

    public SaveHelpPlanFloorRequestDTO setType(String type) {
        this.type = type;
        return this;
    }

    public List<String> getHelpContext() {
        return helpContext;
    }

    public SaveHelpPlanFloorRequestDTO setHelpContext(List<String> helpContext) {
        this.helpContext = helpContext;
        return this;
    }
}
