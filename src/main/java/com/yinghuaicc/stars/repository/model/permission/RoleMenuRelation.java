package com.yinghuaicc.stars.repository.model.permission;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/6/27 下午3:49
 * @Description: 角色菜单关系
 * @Modified:
 */
public class RoleMenuRelation {

    //id
    private String id;

    //角色id
    private String roleId;

    //菜单id
    private String menuId;

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

    public RoleMenuRelation setId(String id) {
        this.id = id;
        return this;
    }

    public String getRoleId() {
        return roleId;
    }

    public RoleMenuRelation setRoleId(String roleId) {
        this.roleId = roleId;
        return this;
    }

    public String getMenuId() {
        return menuId;
    }

    public RoleMenuRelation setMenuId(String menuId) {
        this.menuId = menuId;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public RoleMenuRelation setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public RoleMenuRelation setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public RoleMenuRelation setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public RoleMenuRelation setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
