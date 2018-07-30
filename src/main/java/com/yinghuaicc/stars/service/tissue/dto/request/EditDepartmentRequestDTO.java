package com.yinghuaicc.stars.service.tissue.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/6 下午3:57
 * @Description: 修改部门信息
 * @Modified:
 */
public class EditDepartmentRequestDTO {

    //部门id
    @NotEmpty(message = "TISSUE_EDIT_DEPARTMENT_003")
    private String id;

    //部门名称
    @NotEmpty(message = "TISSUE_EDIT_DEPARTMENT_001")
    private String name;

    //所属公司id
    @NotEmpty(message = "TISSUE_EDIT_DEPARTMENT_002")
    private String companyId;

    //父id
    private String parentId;

    public String getId() {
        return id;
    }

    public EditDepartmentRequestDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public EditDepartmentRequestDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getCompanyId() {
        return companyId;
    }

    public EditDepartmentRequestDTO setCompanyId(String companyId) {
        this.companyId = companyId;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public EditDepartmentRequestDTO setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }
}
