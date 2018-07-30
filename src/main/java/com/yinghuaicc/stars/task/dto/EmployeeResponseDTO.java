package com.yinghuaicc.stars.task.dto;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/17 下午3:04
 * @Description: 人员
 * @Modified:
 */
public class EmployeeResponseDTO {

    private String id;

    //真实姓名
    private String realName;

    //登录名称
    private String loginName;

    //邮箱
    private String email;

    //电话
    private String mobile;

    //所属组织id
    private String belongOrgId;

    //状态
    private String status;

    private boolean delflag;

    public String getId() {
        return id;
    }

    public EmployeeResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getRealName() {
        return realName;
    }

    public EmployeeResponseDTO setRealName(String realName) {
        this.realName = realName;
        return this;
    }

    public String getLoginName() {
        return loginName;
    }

    public EmployeeResponseDTO setLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public EmployeeResponseDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public EmployeeResponseDTO setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getBelongOrgId() {
        return belongOrgId;
    }

    public EmployeeResponseDTO setBelongOrgId(String belongOrgId) {
        this.belongOrgId = belongOrgId;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public EmployeeResponseDTO setStatus(String status) {
        this.status = status;
        return this;
    }

    public boolean isDelflag() {
        return delflag;
    }

    public EmployeeResponseDTO setDelflag(boolean delflag) {
        this.delflag = delflag;
        return this;
    }
}
