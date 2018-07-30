package com.yinghuaicc.stars.service.tissue.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/6 下午3:55
 * @Description: 添加部门
 * @Modified:
 */
public class SaveDepartmentRequestDTO {

    //公司名称
    @NotEmpty(message = "TISSUE_SAVE_DEPARTMENT_001")
    private String name;

    //父id
    @NotEmpty(message = "TISSUE_SAVE_DEPARTMENT_002")
    private String parentId;

    public String getName() {
        return name;
    }

    public SaveDepartmentRequestDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public SaveDepartmentRequestDTO setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }
}
