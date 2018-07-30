package com.yinghuaicc.stars.service.target.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/7 下午2:22
 * @Description: 添加指标
 * @Modified:
 */
public class SaveTargetRequestDTO {

    //指标名称
    @NotEmpty(message = "TARGET_SAVE_TARGET_001")
    private String name;

    //显示名称
    @NotEmpty(message = "TARGET_SAVE_TARGET_002")
    private String showName;

    //指标分类(1:溢租率、2:客销度、3:适配值)
    @NotNull(message = "TARGET_SAVE_TARGET_003")
    private Integer targetType;

    //启用禁用
    @NotNull(message = "TARGET_SAVE_TARGET_006")
    private boolean state;

    public String getName() {
        return name;
    }

    public SaveTargetRequestDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getShowName() {
        return showName;
    }

    public SaveTargetRequestDTO setShowName(String showName) {
        this.showName = showName;
        return this;
    }

    public Integer getTargetType() {
        return targetType;
    }

    public SaveTargetRequestDTO setTargetType(Integer targetType) {
        this.targetType = targetType;
        return this;
    }

    public boolean isState() {
        return state;
    }

    public SaveTargetRequestDTO setState(boolean state) {
        this.state = state;
        return this;
    }


}
