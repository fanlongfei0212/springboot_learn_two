package com.yinghuaicc.stars.service.tissue.dto.response;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/2 上午4:08
 * @Description: 配置员工角色
 * @Modified:
 */
public class ConfEmployeeRoleRequestDTO {

    //员工id
    @NotEmpty(message = "TISSUE_CONF_EMPLOYEE_ROLE_001")
    private String employeeId;

    //员工角色
    @NotNull(message = "TISSUE_CONF_EMPLOYEE_ROLE_002")
    private List<String> roleIds;

    public String getEmployeeId() {
        return employeeId;
    }

    public ConfEmployeeRoleRequestDTO setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public List<String> getRoleIds() {
        return roleIds;
    }

    public ConfEmployeeRoleRequestDTO setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
        return this;
    }
}
