package com.yinghuaicc.stars.service.permission.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/2 上午6:01
 * @Description: 设置角色菜单
 * @Modified:
 */
public class ConfRoleMenuRequestDTO {

    //角色id
    @NotEmpty(message = "PERMISSION_CONF_ROLE_MENU_001")
    private String roleId;

    //菜单id
    @NotNull(message = "PERMISSION_CONF_ROLE_MENU_002")
    private List<String> menuIds = new ArrayList<String>();

    public String getRoleId() {
        return roleId;
    }

    public ConfRoleMenuRequestDTO setRoleId(String roleId) {
        this.roleId = roleId;
        return this;
    }

    public List<String> getMenuIds() {
        return menuIds;
    }

    public ConfRoleMenuRequestDTO setMenuIds(List<String> menuIds) {
        this.menuIds = menuIds;
        return this;
    }
}
