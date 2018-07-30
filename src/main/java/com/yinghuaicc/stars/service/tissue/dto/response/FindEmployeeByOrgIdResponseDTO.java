package com.yinghuaicc.stars.service.tissue.dto.response;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/18 下午2:16
 * @Description: 根据组织查询员工信息
 * @Modified:
 */
public class FindEmployeeByOrgIdResponseDTO {

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

    public String getId() {
        return id;
    }

    public FindEmployeeByOrgIdResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public FindEmployeeByOrgIdResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public FindEmployeeByOrgIdResponseDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public FindEmployeeByOrgIdResponseDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public FindEmployeeByOrgIdResponseDTO setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public boolean isState() {
        return state;
    }

    public FindEmployeeByOrgIdResponseDTO setState(boolean state) {
        this.state = state;
        return this;
    }
}
