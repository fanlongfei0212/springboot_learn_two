package com.yinghuaicc.stars.service.help.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/19 下午3:52
 * @Description: 添加帮扶内容
 * @Modified:
 */
public class SaveHelpContextRequestDTO {

    //内容
    @NotEmpty(message = "SAVE_HELP_CONTEXT_001")
    private String context;

    //类型（1：租金帮扶、2：活动支持、3：点位宣传支持、4：品牌及会员、5：其他）
    @NotNull(message = "SAVE_HELP_CONTEXT_002")
    private Integer type;

    public String getContext() {
        return context;
    }

    public SaveHelpContextRequestDTO setContext(String context) {
        this.context = context;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public SaveHelpContextRequestDTO setType(Integer type) {
        this.type = type;
        return this;
    }
}
