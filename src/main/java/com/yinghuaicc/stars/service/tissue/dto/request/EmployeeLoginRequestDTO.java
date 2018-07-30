package com.yinghuaicc.stars.service.tissue.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/2 下午7:03
 * @Description: 员工登录
 * @Modified:
 */
public class EmployeeLoginRequestDTO {

    //用户名
    @NotEmpty(message = "TISSUE_EMPLOYEE_LOGIN_001")
    private String userName;

    //密码
    @NotEmpty(message = "TISSUE_EMPLOYEE_LOGIN_002")
    private String userPassword;

    public String getUserName() {
        return userName;
    }

    public EmployeeLoginRequestDTO setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public EmployeeLoginRequestDTO setUserPassword(String userPassword) {
        this.userPassword = userPassword;
        return this;
    }
}
