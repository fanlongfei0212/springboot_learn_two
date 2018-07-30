package com.yinghuaicc.stars.service.permission.dto.response;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/2 上午4:32
 * @Description: 角色菜单信息
 * @Modified:
 */
public class RoleAllMenuResponseDTO {

    //角色id
    private String roleId;

    //角色名称
    private String roleName;

    //角色菜单树信息
    private List<LoginMenuResponseDTO> menuTree = new ArrayList<>();

    public String getRoleId() {
        return roleId;
    }

    public RoleAllMenuResponseDTO setRoleId(String roleId) {
        this.roleId = roleId;
        return this;
    }

    public String getRoleName() {
        return roleName;
    }

    public RoleAllMenuResponseDTO setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public List<LoginMenuResponseDTO> getMenuTree() {
        return menuTree;
    }

    public RoleAllMenuResponseDTO setMenuTree(List<LoginMenuResponseDTO> menuTree) {
        this.menuTree = menuTree;
        return this;
    }
}
