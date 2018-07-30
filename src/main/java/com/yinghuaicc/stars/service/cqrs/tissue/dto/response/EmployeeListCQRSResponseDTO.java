package com.yinghuaicc.stars.service.cqrs.tissue.dto.response;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/18 下午2:42
 * @Description:
 * @Modified:
 */
public class EmployeeListCQRSResponseDTO {

    private String id;

    //名称
    private String name;

    //手机
    private String phone;

    //邮箱
    private String email;

    //用户名
    private String userName;

    //是否启用（true：启用，false：禁用）
    private boolean state;

    //部门名称
    private String deptName;

    public String getId() {
        return id;
    }

    public EmployeeListCQRSResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public EmployeeListCQRSResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public EmployeeListCQRSResponseDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public EmployeeListCQRSResponseDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public EmployeeListCQRSResponseDTO setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public boolean isState() {
        return state;
    }

    public EmployeeListCQRSResponseDTO setState(boolean state) {
        this.state = state;
        return this;
    }

    public String getDeptName() {
        return deptName;
    }

    public EmployeeListCQRSResponseDTO setDeptName(String deptName) {
        this.deptName = deptName;
        return this;
    }
}
