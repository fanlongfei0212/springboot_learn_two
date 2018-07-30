package com.yinghuaicc.stars.service.target.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/7 下午2:30
 * @Description: 禁用/启用指标
 * @Modified:
 */
public class IsAbleTargetRequestDTO {

    //id
    @NotEmpty(message = "TARGET_ISABLE_TARGET_001")
    private String id;

    //禁用：false、启用：true
    @NotNull(message = "TARGET_ISABLE_TARGET_002")
    private boolean state;

    public String getId() {
        return id;
    }

    public IsAbleTargetRequestDTO setId(String id) {
        this.id = id;
        return this;
    }

    public boolean isState() {
        return state;
    }

    public IsAbleTargetRequestDTO setState(boolean state) {
        this.state = state;
        return this;
    }
}
