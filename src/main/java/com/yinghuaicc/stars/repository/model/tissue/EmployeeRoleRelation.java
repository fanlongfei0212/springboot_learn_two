package com.yinghuaicc.stars.repository.model.tissue;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/6/27 下午6:51
 * @Description: 员工角色关系
 * @Modified:
 */
public class EmployeeRoleRelation {

    //id
    private String id;

    //员工id
    private String employeeId;

    //角色id
    private String roleId;

    //创建时间
    private LocalDateTime createTime;

    //修改时间
    private LocalDateTime modifyTime;

    //创建人
    private String createUser;

    //修改人
    private String modifyUser;

    public String getId() {
        return id;
    }

    public EmployeeRoleRelation setId(String id) {
        this.id = id;
        return this;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public EmployeeRoleRelation setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public String getRoleId() {
        return roleId;
    }

    public EmployeeRoleRelation setRoleId(String roleId) {
        this.roleId = roleId;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public EmployeeRoleRelation setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public EmployeeRoleRelation setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public EmployeeRoleRelation setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public EmployeeRoleRelation setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
