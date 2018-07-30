package com.yinghuaicc.stars.service.help.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/19 下午4:21
 * @Description: 编辑帮扶内容
 * @Modified:
 */
public class EditHelpContextRequestDTO {

    //id
    @NotEmpty(message = "EDIT_HELP_CONTEXT_001")
    private String id;

    //内容
    @NotEmpty(message = "EDIT_HELP_CONTEXT_002")
    private String context;

    //类型（1：租金帮扶、2：活动支持、3：点位宣传支持、4：品牌及会员、5：其他）
    @NotNull(message = "EDIT_HELP_CONTEXT_003")
    private Integer type;

    public String getId() {
        return id;
    }

    public EditHelpContextRequestDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getContext() {
        return context;
    }

    public EditHelpContextRequestDTO setContext(String context) {
        this.context = context;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public EditHelpContextRequestDTO setType(Integer type) {
        this.type = type;
        return this;
    }
}
