package com.yinghuaicc.stars.service.tissue.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/29 下午4:43
 * @Description: 启用禁用员工
 * @Modified:
 */
public class StateEmployeeRequestDTO {

    //员工id
    @NotEmpty(message = "STATE_EMPLOYEE_001")
    private String id;

    //状态(false:禁用，true:启用)
    @NotNull(message = "STATE_EMPLOYEE_002")
    private boolean state;

    public String getId() {
        return id;
    }

    public StateEmployeeRequestDTO setId(String id) {
        this.id = id;
        return this;
    }

    public boolean isState() {
        return state;
    }

    public StateEmployeeRequestDTO setState(boolean state) {
        this.state = state;
        return this;
    }
}
