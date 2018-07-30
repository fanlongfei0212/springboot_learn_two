package com.yinghuaicc.stars.service.permission.dto.response;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/2 上午3:30
 * @Description: 所有角色
 * @Modified:
 */
public class RoleAllResponseDTO {

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

    public RoleAllResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RoleAllResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public RoleAllResponseDTO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public RoleAllResponseDTO setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public RoleAllResponseDTO setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public RoleAllResponseDTO setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
