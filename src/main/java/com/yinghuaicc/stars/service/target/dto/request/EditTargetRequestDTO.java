package com.yinghuaicc.stars.service.target.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/7 下午2:25
 * @Description: 编辑指标
 * @Modified:
 */
public class EditTargetRequestDTO {

    //id
    @NotEmpty(message = "TARGET_EDIT_TARGET_005")
    private String id;

    //指标名称
    @NotEmpty(message = "TARGET_EDIT_TARGET_001")
    private String name;

    //显示名称
    @NotEmpty(message = "TARGET_EDIT_TARGET_002")
    private String showName;

    //指标分类(1:溢租率、2:客销度、3:适配值)
    @NotNull(message = "TARGET_EDIT_TARGET_003")
    private Integer targetType;

    //是否启用
    @NotNull(message = "TARGET_EDIT_TARGET_006")
    private boolean state;

    public String getId() {
        return id;
    }

    public EditTargetRequestDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public EditTargetRequestDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getShowName() {
        return showName;
    }

    public EditTargetRequestDTO setShowName(String showName) {
        this.showName = showName;
        return this;
    }

    public Integer getTargetType() {
        return targetType;
    }

    public EditTargetRequestDTO setTargetType(Integer targetType) {
        this.targetType = targetType;
        return this;
    }

    public boolean isState() {
        return state;
    }

    public EditTargetRequestDTO setState(boolean state) {
        this.state = state;
        return this;
    }
}
