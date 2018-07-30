package com.yinghuaicc.stars.service.permission.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/2 上午1:53
 * @Description: 员工角色
 * @Modified:
 */
public class EmployeeRoleResponseDTO {

    //id
    private String id;

    //角色名称
    private String name;

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

    public EmployeeRoleResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public EmployeeRoleResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public EmployeeRoleResponseDTO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public EmployeeRoleResponseDTO setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public EmployeeRoleResponseDTO setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public EmployeeRoleResponseDTO setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
