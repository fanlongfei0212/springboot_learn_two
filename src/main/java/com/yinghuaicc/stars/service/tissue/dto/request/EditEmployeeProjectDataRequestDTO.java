package com.yinghuaicc.stars.service.tissue.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/5 下午3:34
 * @Description: 设置员工数据权限
 * @Modified:
 */
public class EditEmployeeProjectDataRequestDTO {

    //员工id
    @NotEmpty(message = "TISSUE_EDIT_EMPLOYEE_PROJECT_DATA_002")
    private String employeeId;

    //项目id
    @NotNull(message = "TISSUE_EDIT_EMPLOYEE_PROJECT_DATA_001")
    private List<String> projectIds = new ArrayList<String>();

    public String getEmployeeId() {
        return employeeId;
    }

    public EditEmployeeProjectDataRequestDTO setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public List<String> getProjectIds() {
        return projectIds;
    }

    public EditEmployeeProjectDataRequestDTO setProjectIds(List<String> projectIds) {
        this.projectIds = projectIds;
        return this;
    }
}
